var express = require("express");
var router= express.Router();
var CampingGround = require("../models/campground.js");


// ======
// Campgrounds
//=======

// basic root routes
router.get('/',function(req,res){
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

// registration route
router.post("/",isLoggedIn,function(req,res){
    // get data from forms and add to campground array
    var name = req.body.name;
    var image= req.body.image;
    var description=req.body.description;
    var newAuthor={
        id: req.user._id,
        username: req.user.username
    }
    var newCampinggrounds ={name:name,image:image,description: description,author: newAuthor};
    console.log(req.user);
    
     //create a new campground and save it to DB
  CampingGround.create(newCampinggrounds,function(err,newCampinggrounds){
      if(err){
          console.log(err)
      }
      else{
          //redirect back to campgrounds page
          console.log(newCampinggrounds)
    res.redirect("/campgrounds")
      }
  })
    
})

// new route
router.get('/new',isLoggedIn,function(req, res) {
    res.render("campgrounds/new.ejs");
});

// show us one info about the campground.
router.get("/:id",function(req, res) {
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

// campground routes edit
router.get("/:id/edit",function(req, res) {
    CampingGround.findById(req.params.id,function(err,foundCampgrounds){
        if(err){
            res.redirect("/campgrounds");
        }
        else{
             res.render("campgrounds/edit.ejs",{campground: foundCampgrounds});
        }
    })
});



// update campground routes
router.put("/:id",function(req,res){
    // find and update the campground
    CampingGround.findByIdAndUpdate(req.params.id,req.body.campground,function(err,updatedCampingGround){
        if(err){
            res.redirect("/campgrounds");
        }   
        else{
            res.redirect("/campgrounds/" + req.params.id);
        }
    })
    // redirect to the campground
})

// delete route
router.delete("/:id",function(req,res){
    CampingGround.findByIdAndRemove(req.params.id,function(err){
        if(err){
            res.redirect("/campgrounds");
        }
        else{
             res.redirect("/campgrounds");
        }
    })
})

// middleware logic
function isLoggedIn(req, res, next){
    if(req.isAuthenticated()){
        return next();
    }
    res.redirect("/login");
}

module.exports = router;