var mongoose = require('mongoose');

// this allows us to all which are happening
mongoose.set('debug', true);
mongoose.connect('mongodb://localhost/todo-api-app');

mongoose.Promise = Promise;

module.exports.Todo = require("./todos.js");