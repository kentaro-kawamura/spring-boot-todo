package com.kawamura.todo.repository

import com.kawamura.todo.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long>