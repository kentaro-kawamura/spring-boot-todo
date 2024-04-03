package com.kawamura.todo.controller

import com.kawamura.todo.serivice.TodoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class TodoController(private val todoService: TodoService) {

    @GetMapping("/todos")
    fun listTodos(model: Model): String {
        val todos = todoService.findAll()
        model["todos"] = todos
        return "todo_list"
    }

    @PostMapping("/create")
    fun registTodo(model: Model): String {
        val newTodo = todoService.createTodo("first-title", "first-description")
        model["newtodo"] = newTodo
        model["title"] = newTodo.title
        model["description"] = newTodo.description
        return "todo_form"
    }
}