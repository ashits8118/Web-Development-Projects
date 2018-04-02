var express = require("express");
var app = express();
var bodyParser = require("body-parser");
var mongoose=require("mongoose");
var passport = require("passport");
var LocalStrategy = require("passport-local");
var CampingGround = require("./models/campground.js");
var  User        = require("./models/user.js");
var Comments = require("./models/comment.js");
var seedDB = require("./seeds.js");



mongoose.connect("mongodb://localhost/yelp_camp_v6");

app.use(bodyParser.urlencoded({extended: true}));
//  app.use(express.static(__dirname + "/public"));
app.use(express.static(__dirname + "/public"));
console.log(__dirname);
seedDB();

// PASSPORT Config code
app.use(require("express-session")({
    secret: "the camping website",
    resave: false,
    saveUninitialized: false
}));
app.use(passport.initialize());
app.use(passport.session());
passport.use(new LocalStrategy(User.authenticate()));
passport.serializeUser(User.serializeUser());
passport.deserializeUser(User.deserializeUser());

app.use(function(req, res, next){
   res.locals.currentUser = req.user;
   next();
});

app.get("/",function(req,res){
  res.render("home.ejs");
});

// ======
// Campgrounds
//=======

app.get('/campgrounds',function(req,res){
    console.log(req.user);
       //get all campgrounds from DB
       CampingGround.find({},function(err,allCampgrounds){
           if(err){
               console.log(err)
           }
           else {
               res.render("campgrounds/camps.ejs",{campgrounds:allCampgrounds, currentUser: req.user})
               
           }
       })
       
});

app.post("/campgrounds",function(req,res){
    // get data from forms and add to campground array
    var name = req.body.name;
    var image= req.body.image;
    var description=req.body.description;
    var newCampinggrounds ={name:name,image:image,description: description};
    
     //create a new campground and save it to DB
  CampingGround.create(newCampinggrounds,function(err,newCampinggrounds){
      if(err){
          console.log(err)
      }
      else{
          //redirect back to campgrounds page
    res.redirect("/campgrounds")
      }
  })
    
})

app.get('/campgrounds/new',function(req, res) {
    res.render("campgrounds/new.ejs");
});

// show us one info abou the campground.
app.get("/campgrounds/:id",function(req, res) {
     CampingGround.findById(req.params.id).populate("comments").exec(function(err,foundCampgrounds){
        if(err){
            console.log(err)
        }
        else{
                //render show template with that campground
                  res.render("campgrounds/show.ejs",{foundCampgrounds})
        }
    })
});

//================
// comments routes
//================
app.get("/campgrounds/:id/comments/new",isLoggedIn,function(req, res) {
    
    // find campground by Id
    CampingGround.findById(req.params.id,function(err,campground){
        if(err){
            console.log(err);
        }
        else {
            res.render("comments/new.ejs",{campground});
        }
    })
});

app.post("/campgrounds/:id/comments",isLoggedIn,function(req,res){
    // lookup campground using ID
    CampingGround.findById(req.params.id,function(err,campground){
        if(err){
            console.log(err);
            res.redirect("/campgrounds");
        }
        else{
            //  console.log("campground details");
            // console.log(campground);
          
            // create new comments
     Comments.create(req.body.comments,function(err,comment){
         if(err){
             console.log(err)
         }
         else{
                 // connect new comment to campground
             campground.comments.push(comment);
             campground.save();
                 // redirect to campground show page
             res.redirect('/campgrounds/' + campground._id);
         }
     })
        }
    });
    
    
});


//=========
//Authentication Routes
//=========


// route for register form  
app.get("/register", function(req, res){
   res.render("register.ejs"); 
});

// route for sign up

app.post("/register", function(req, res){
    // var newUser = new User({username: req.body.username});
    User.register(new User({username: req.body.username}), req.body.password, function(err, user){
        if(err){
            console.log(err);
            return res.render("register.ejs");
        }
        passport.authenticate("local")(req, res, function(){
           res.redirect("/campgrounds"); 
        });
    });
});

// route for login form
app.get("/login", function(req, res){
   res.render("login.ejs"); 
});
// route for login logic
app.post("/login",passport.authenticate("local", 
    {
        successRedirect: "/campgrounds",
        failureRedirect: "/login"
    }) ,function(req, res) {
   
});

// logout route

app.get("/logout", function(req, res){
   req.logout();
   res.redirect("/campgrounds");
});

function isLoggedIn(req, res, next){
    if(req.isAuthenticated()){
        return next();
    }
    res.redirect("/login");
}

app.listen(process.env.PORT, process.env.IP,function(){
    console.log("The Camping Ground WebSite has started!!")
});