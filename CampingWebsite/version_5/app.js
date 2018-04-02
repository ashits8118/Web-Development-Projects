var express = require("express");
var app = express();
var bodyParser = require("body-parser");
var mongoose=require("mongoose");
var CampingGround = require("./models/campground.js");
var Comments = require("./models/comment.js");
var seedDB = require("./seeds.js");



mongoose.connect("mongodb://localhost/yelp_camp");

app.use(bodyParser.urlencoded({extended: true}));
//  app.use(express.static(__dirname + "/public"));
app.use(express.static(__dirname + "/public"));
console.log(__dirname);
seedDB();

app.get("/",function(req,res){
  res.render("home.ejs");
});

app.get('/campgrounds',function(req,res){
       //get all campgrounds from DB
       CampingGround.find({},function(err,allCampgrounds){
           if(err){
               console.log(err)
           }
           else {
               res.render("campgrounds/camps.ejs",{campgrounds:allCampgrounds})
               
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


// comments routes
app.get("/campgrounds/:id/comments/new",function(req, res) {
    
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

app.post("/campgrounds/:id/comments",function(req,res){
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

app.listen(process.env.PORT, process.env.IP,function(){
    console.log("The Camping Ground WebSite has started!!")
});