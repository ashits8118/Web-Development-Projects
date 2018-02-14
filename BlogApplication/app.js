
var express = require("express")
var mongoose = require("mongoose")
var methodOverride = require("method-override")
var bodyParser=require("body-parser")
var sanitizer=require("express-sanitizer")

var app = express();
// app config
mongoose.connect("mongodb://localhost/blog_app");
app.use(express.static("public"))
app.use(bodyParser.urlencoded({extended: true}));
app.use(methodOverride("_method"));
var expressSanitizer=require("express-sanitizer")

// mongoose congig
var blogAppSchema = new mongoose.Schema({
   title: String,
   image: String,
   body: String,
   created: {type: Date, default: Date.now()}
});
var blogApp = mongoose.model("Blog",blogAppSchema);


//  blogApp.create({
//      title:"test blog",
//     image:"https://onmilwaukee.com/images/articles/ca/camping/camping_fullsize_story1.jpg?20080730123152",
//     body:"hi,Hello!",
    
// });


// restFul Routes
app.get("/",function(req, res) {
    res.redirect("/blogs");
})

// INDEX Routes
app.get("/blogs",function(req,res){
    blogApp.find({},function(err,blogs){
        if(err){
            console.log("Error");
        }
        else {
            res.render("index.ejs",{blog : blogs});
        }
    })
});

// New Routes
app.get("/blogs/new",function(req, res) {
    res.render("new.ejs");
})

app.post("/blogs",function(req,res){
    // create blog
    req.body.blog.body = req.sanitize( req.body.blog.body);
    blogApp.create(req.body.blog,function(err,blog){
        if(err){
            res.render("new");
        }
        else{
            res.redirect("/blogs");
        }
    })
    // than redirect to the index.ejs
})
//show Route
app.get("/blogs/:id",function(req, res) {
    blogApp.findById(req.params.id,function(err,blogs){
        if(err){
            res.redirect("/blogs");
        }
        else{
            res.render("show.ejs",{blog: blogs});
        }
    })
});

app.get("/blogs/:id/edit",function(req, res) {
    blogApp.findById(req.params.id,function(err,individualBlog){
        if(err){
            res.redirect("/blogs");
        }
        else{
              res.render("edit.ejs",{blog:individualBlog});
        }
    });
});
    
    //update route
app.put("/blogs/:id",function(req,res){
      req.body.blog.body = req.sanitize( req.body.blog.body);
           blogApp.findByIdAndUpdate(req.params.id,req.body.blog ,function(err,updatedBlog){
    if(err){
        res.redirect("/blogs")
    }    
    else{
        res.redirect("/blogs/" + req.params.id)
    }
    })
    
})
//Delete Route  
app.delete("/blogs/:id",function(req,res){
 blogApp.findByIdAndRemove(req.params.id,function(err){
     if(err){
         res.redirect("/blogs");
     }
     else
     res.redirect("/blogs");
 })
})

app.listen(process.env.PORT,process.env.IP,function(){
    console.log("Blog Server is Running !!")
})
