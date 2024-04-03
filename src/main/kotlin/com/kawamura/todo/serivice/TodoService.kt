package com.kawamura.todo.serivice

import com.kawamura.todo.model.Todo
import com.kawamura.todo.repository.TodoRepository
import org.springframework.context.annotation.Description
import org.springframework.stereotype.Service

@Service
class TodoService(private val todoRepository: TodoRepository) {

    fun findAll(): List<Todo> {
        return todoRepository.findAll()
    }

    fun createTodo(title: String,description: String): Todo {
        val todo = Todo(title = title, description = description)
        todoRepository.save(todo)
        return todo
    }
}