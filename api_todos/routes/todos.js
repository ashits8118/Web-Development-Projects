var express = require("express");
// this help break the routes into modular chunks.
var router = express.Router();
var db= require("../models");
var helpers = require("../helpers/todos.js");

router.route('/')
 .get(helpers.getTodos)
 .post(helpers.createTodo)
 
router.route('/:todoId')
  .get(helpers.getTodo)
  .put(helpers.updateTodo)
  .delete(helpers.deleteTodo)
module.exports = router;