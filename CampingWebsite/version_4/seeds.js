var mongoose = require("mongoose");
var CampingGround = require("./models/campground.js");
var Comment = require("./models/comment.js");

var data=[
    {name:"Cloud's Rest",image:"http://www.hdwallpapers.in/walls/beautiful_scenery-wide.jpg", 
        description:"nice place"
        
    },
        {
         name:"Dandeli",image:"http://hd.wallpaperswide.com/thumbs/summer_scenery-t2.jpg", 
        description:"nice place in India"   
        },
         {
         name:"Campground !!",image:"http://bnearme.com/wp-content/uploads/2015/01/Campgrounds-Near-Me1.jpg", 
        description:"superbb!!"   
        }
]


function seedDB(){
    CampingGround.remove({},function(err){
    if(err){
        console.log("removed campgrounds");
    }
    else{
        // add a few campdrounds
data.forEach(function(seed){
   CampingGround.create(seed,function(err,campground){
       if(err){
           console.log("added a campdrounds");
       }
       else{
           console.log("added a new campground");
           // create a comment
           Comment.create({
               text: "Its an awesome place",
               author: "ashit"
           },function(err,comment){
                   if(err){
                       console.log("error")
                   }
                   else{
                 campground.comments.push(comment);
                  campground.save();
                  console.log("created new comment");
                   }
               });
       }
   }) 
});
    }
});

}

module.exports = seedDB;
