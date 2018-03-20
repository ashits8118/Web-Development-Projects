/* global $ */
$(document).ready(function(){
    // here we are going to request "/api/todos"
    $.getJSON("/api/todos")
    .then(addTodos)
       
       
    $('#todoInput').keypress(function(event){
        if(event.which ==13){
            createTodo();
        }
    })
    
    $('.list').on('click','span',function(e){
    //   console.log("clicked")
    // $(this).parent().remove();
    // console.log($(this).parent().data('id'))
      e.stopPropagation();
     deleteTodo($(this).parent());
    })
    
    $('.list').on('click', 'li', function(){
        // console.log($(this));
      updateTodo($(this))
  })
})


function addTodos(todos){
    // add todos to the page
   todos.forEach(function(todo){
    // console.log(todo.name);
   addTodo(todo)
   });
}

function addTodo(todo){
  var newTodo = $('<li class="task">'+todo.name +' <span>X</span></li>');
  newTodo.data('id', todo._id);  
  newTodo.data('completed', todo.completed);
  if(todo.completed){
    newTodo.addClass("done");
  }
  $('.list').append(newTodo);
}

function createTodo(){
// send a request to create new Todo
 var usrInput = $('#todoInput').val();
// console.log(usrInput);
    // $.post("api/todos",{name: })
$.post('/api/todos',{name: usrInput})
.then(function(newTodo){
     $('#todoInput').val('');
    // console.log(newTodo)
    addTodo(newTodo);
})
.catch(function(err){
    console.log(err);
})
}


function deleteTodo(todo){
    var clickedId = todo.data('id');
     var deleteUrl = "/api/todos/" + clickedId;
     $.ajax({
         method: 'DELETE',
         url: deleteUrl
     })
     .then(function(data){
        todo.remove();
     })
     .catch(function(err){
    console.log(err);
    })
}

function updateTodo(todo){
  var clickedId = todo.data('id');
  var updateUrl = '/api/todos/' + clickedId;
    var isDone = !todo.data('completed');
     var updateData = {completed: isDone}
    //  console.log(updateData)
//   console.log(todo.data('completed'))
 $.ajax({
    method: 'PUT',
    url: updateUrl,
    data: updateData
  })
  .then(function(updatedTodo){
    todo.toggleClass("done");
    todo.data('completed', isDone);
  })
}