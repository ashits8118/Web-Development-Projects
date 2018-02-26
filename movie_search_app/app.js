var express = require("express");
var app = express();
var request = require("request");


app.get("/",function(req, res) {
    res.render("search.ejs");
})
app.get("/results",function(req,res){
    // console.log(req.query.search);
    var value = req.query.search;
    var url = "http://www.omdbapi.com/?s=" + value + "&apikey=thewdb"
   request(url,
   function(error,response,body){
       if(!error && response.statusCode ==200){
           var parsedData = JSON.parse(body);
        //   res.send(parsedData)
        res.render("results.ejs",{parsedData})
       }
   }) 
});
app.listen(process.env.PORT,process.env.IP,function(){
    console.log("Server has started !!")
})