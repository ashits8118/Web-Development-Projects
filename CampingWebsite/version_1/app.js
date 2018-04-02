var express = require("express");
var app = express();
var bodyParser = require("body-parser")

app.use(bodyParser.urlencoded({extended: true}));

 var camgrounds = [
       {name:" Shlok", image :"http://www.nationalparks.nsw.gov.au/~/media/DF58734103EF43669F1005AF8B668209.ashx"},
       {name:" Smoky Mountain", image :"https://www.fs.usda.gov/Internet/FSE_MEDIA/stelprdb5306226.jpg"}
       ]; 
app.get("/",function(req,res){
  res.render("home.ejs");
});

app.get('/campgrounds',function(req,res){
       res.render("camps.ejs",{camgrounds});
});

app.post("/campgrounds",function(req,res){
    // get data from forms and add to campground array
    var image= req.body.image;
    var newCampinggrounds ={name:name,image:image};
    camgrounds.push(newCampinggrounds);
    // redirect back to campgrounds page
    res.redirect("/campgrounds");
})

app.get('/campgrounds/new',function(req, res) {
    res.render("new.ejs");
})
app.listen(process.env.PORT, process.env.IP,function(){
    console.log("The Camping Ground WebSite has started!!")
})