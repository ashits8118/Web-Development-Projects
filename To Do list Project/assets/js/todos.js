//check off specific todos by clicking
//  li is clicked inside on ul
$("ul").on("click","li",function(){
$(this).toggleClass("completed");
})

//click on X to delete Todos
//span is clicked inside of ul
$("ul").on("click","span",function(event){
	$(this).parent().fadeOut(500,function(){
		$(this).remove
	});// removes parenting 
	event.stopPropagation();
})

$("input[type='text']").keypress(function(event){
if(event.which === 13){
	console.log("you hit enter")

	//grabbing new todo text
	var todoText = $(this).val();
	$(this).val(" ");
 // create a new li and add to ul
 // $("ul").append("<li>This is new li that we appendeed to this  ul</li>")
$("ul").append("<li><span><i class='fa fa-trash'> </i></span> "+ todoText + "</li>")
}
})

$(".fa-plus").click(function(){
	$("input[type='text']").fadeToggle();
});



