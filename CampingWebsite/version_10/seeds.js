var mongoose = require("mongoose");
var CampingGround = require("./models/campground.js");
var Comment = require("./models/comment.js");

var data=[
    {name:"Cloud's Rest",image:"http://www.hdwallpapers.in/walls/beautiful_scenery-wide.jpg", 
        description:"Brisket tongue prosciutto, pork loin drumstick turkey bacon burgdoggen biltong meatball. Pancetta pork loin pork belly filet mignon. Brisket meatloaf venison picanha, swine turkey ham hock sausage fatback boudin. Biltong spare ribs tri-tip sirloin doner boudin capicola."
        
    },
        {
         name:"Dandeli",image:"https://images.thrillophilia.com/image/upload/s--6exjy1dv--/c_fill,f_auto,fl_strip_profile,h_800,q_auto,w_1300/v1/images/photos/000/008/731/original/Sathodi.jpg.jpg?1458194136", 
        description:"Andouille burgdoggen biltong shoulder turducken, salami kielbasa boudin flank picanha meatloaf rump cupim shank pork belly. Andouille tongue flank jerky, pork kevin t-bone swine pork loin. Kielbasa sirloin corned beef buffalo leberkas capicola shankle, pig spare ribs. Chuck pork chop spare ribs, cow tongue boudin bacon fatback tenderloin flank corned beef kevin porchetta pork loin. Fatback tenderloin tongue swine, pastrami sirloin shankle alcatra ball tip cupim chuck ham shoulder meatloaf kielbasa. Turkey pastrami tenderloin meatball sirloin brisket. Prosciutto tri-tip jowl ham hock corned beef tenderloin pork chop strip steak ham porchetta ribeye beef ribs rump cupim chicken."   
        },
         {
         name:"Campground !!",image:"https://acadiamagic.com/940x366/campground-1301.jpg", 
        description:"Ground round landjaeger ball tip flank, boudin swine drumstick meatball andouille shankle pastrami alcatra. Capicola pork tail doner buffalo bresaola chuck shank cow porchetta leberkas sausage biltong venison kielbasa. Pastrami kielbasa pork chop tail, picanha cow flank filet mignon hamburger corned beef ribeye tenderloin ground round capicola sausage. Jowl cow pancetta, prosciutto spare ribs short ribs shoulder ball tip t-bone doner drumstick landjaeger leberkas pork chop. Rump capicola prosciutto drumstick. Chuck turducken swine picanha kielbasa pig drumstick beef. Biltong capicola shankle, shank turducken chuck frankfurter hamburger porchetta ham beef doner kielbasa."   
        }
]


function seedDB(){
    CampingGround.remove({},function(err){
        if(err){
            console.log(err);
        }
            console.log("removed campgrounds");
             // add some camprgrounds 
        data.forEach(function(seed){
            CampingGround.create(seed,function(err,campground){
                if(err){
                    console.log(err)
                }
                else{
                    console.log("added a campground");
                      // also add comments
                Comment.create(
                    {text:"this is a awesome place",
                                author: "Ashit"
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
        })
        
      
        })
    
}

module.exports = seedDB;
