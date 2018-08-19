var url = 'https://ron-swanson-quotes.herokuapp.com/v2/quotes'
var xhrbtn = document.querySelector("#xhr");
var fetchbtn = document.querySelector("#fetch");
var axiosbtn = document.querySelector("#axios");
var display = document.querySelector("#quote");


xhrbtn.addEventListener("click", function(){
    var XHR = new XMLHttpRequest();
  XHR.onreadystatechange = function(){
    if(XHR.readyState == 4 && XHR.status == 200){
       console.log(typeof XHR.responseText);
      var data = JSON.parse(XHR.responseText)[0];
     console.log(data);
      display.innerText= data;
    }
  }
  XHR.open("GET", url);
  XHR.send();
});

fetchbtn.addEventListener("click", function(){
  fetch(url)
  .then(function(req){
    req.json().then(function(data){
      // console.log(data[0]);
      display.innerText=data[0];
    })
  })
  .catch(function(){
    alert("ERROR!")
  })
});

$('#jquery').click(function(){
  $.getJSON(url)
  .done(function(data){
    $('#quote').text(data[0]);
  });
});


axiosbtn.addEventListener("click", function(){
axios.get(url)
.then(function(res){
  // console.log(typeof res);
  // console.log(res.data[0]);
  display.innerText=res.data[0];
})
.catch(function(){
  console.log('error');
})
})