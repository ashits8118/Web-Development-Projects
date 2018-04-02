var express = require("express");
var router= express.Router({mergeParams: true});
var CampingGround = require("../models/campground.js");
var Comments = require("../models/comment.js");

//================
// comments routes
//================

// for new comments
router.get("/new",isLoggedIn,function(req, res) {
    console.log(req.params.id);
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


// to create new comments
router.post("/",isLoggedIn,function(req,res){
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

// middleware to check if the use is logged in.
function isLoggedIn(req, res, next){
    if(req.isAuthenticated()){
        return next();
    }
    res.redirect("/login");
}

module.exports = router;