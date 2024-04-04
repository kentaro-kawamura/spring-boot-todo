package com.kawamura.todo.controller

import com.kawamura.todo.model.Todo
import com.kawamura.todo.serivice.TodoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class TodoController(private val todoService: TodoService) {

    @GetMapping("/todos")
    fun listTodos(model: Model): String {
        val todos = todoService.findAll()
        model["todos"] = todos
        return "todo_list"
    }

    @GetMapping("todo/{id}")
    fun getTodo(model: Model, @PathVariable("id") id: Long): String {
        val todo = todoService.findById(id)
        model["todo"] = todo
        return "todo_page"
    }

    @GetMapping("/create")
    fun showForm(model: Model): String {
//        model["todoTest"] = Todo()
        return "todo_form"
    }

    @PostMapping("/create")
    fun registTodo(@ModelAttribute todoTest: Todo, model: Model): String {
        //val newTodo = todoService.createTodo("first-title", "first-description")
        val newTodo = todoService.createTodo(todoTest)
        model["newTodo"] = newTodo
        return "todo_page"
    }
}