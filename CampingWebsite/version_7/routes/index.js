
var express = require("express");
var router= express.Router();
var passport= require("passport");
var User = require("../models/user.js");


router.get("/",function(req,res){
  res.render("home.ejs");
});




//=========
//Authentication Routes
//=========


// route for register form  
router.get("/register", function(req, res){
   res.render("register.ejs"); 
});

// route for sign up

router.post("/register", function(req, res){
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
router.get("/login", function(req, res){
   res.render("login.ejs"); 
});
// route for login logic
router.post("/login",passport.authenticate("local", 
    {
        successRedirect: "/campgrounds",
        failureRedirect: "/login"
    }) ,function(req, res) {
   
});

// logout route

router.get("/logout", function(req, res){
   req.logout();
   res.redirect("/campgrounds");
});


// middleware logic
function isLoggedIn(req, res, next){
    if(req.isAuthenticated()){
        return next();
    }
    res.redirect("/login");
}



module.exports = router;