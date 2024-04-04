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

    fun findById(id: Long): Todo {
        return todoRepository.getReferenceById(id)
    }

    fun createTodo(todo: Todo): Todo {
        return todoRepository.save(todo)
    }
}