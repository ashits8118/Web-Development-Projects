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

var commentRoutes= require("./routes/comments.js");
var campgroundRoutes= require("./routes/campgrounds.js");
var indexRoutes= require("./routes/index.js");

mongoose.connect("mongodb://localhost/yelp_camp_v8");

app.use(bodyParser.urlencoded({extended: true}));
//  app.use(express.static(__dirname + "/public"));
app.use(express.static(__dirname + "/public"));
console.log(__dirname);

// seeding the database
// seedDB();

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

app.use("/campgrounds/:id/comments/",commentRoutes);
app.use("/campgrounds",campgroundRoutes);
app.use(indexRoutes);


app.listen(process.env.PORT, process.env.IP,function(){
    console.log("The Camping Ground WebSite has started!!")
});