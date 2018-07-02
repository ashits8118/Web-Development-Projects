var p1 = document.getElementById("p1");
var p2 = document.getElementById("p2");
var reset = document.getElementById("reset");
var p1Display = document.querySelector("#p1Display"); 
var p2Display = document.querySelector("#p2Display"); 
var winningScoreDisplay = document.querySelector("p span");
var p1Score = 0;
var p2Score = 0;
var gameOver = false;
var winningScore = 5;
var input= document.querySelector("input");

p1.addEventListener("click",function(){
    if(!gameOver){
        p1Score++;
        // console.log(p1Score, winningScore);
        if(p1Score === winningScore){
            // console.log("Game Over");
            p1Display.classList.add("winner");
            gameOver = true;

        }
        p1Display.textContent = p1Score;
    }
});

p2.addEventListener("click",function(){
    if(!gameOver){
        p2Score++;
        if(p2Score === winningScore){
            // console.log("Game Over");
            p2Display.classList.add("winner");
            gameOver = true;
        }
    }
    p2Display.textContent = p2Score;
});

reset.addEventListener("click", function(){
    resetFunction();
});
function resetFunction(){
	p1Score = 0;
	p2Score = 0;
	p1Display.textContent = 0;
	p2Display.textContent = 0;
	p1Display.classList.remove("winner");
	p2Display.classList.remove("winner");
	gameOver = false;
}

input.addEventListener("change",function(){
    winningScoreDisplay.textContent = input.value;
    winningScore = Number(input.value);

   resetFunction();
   
})