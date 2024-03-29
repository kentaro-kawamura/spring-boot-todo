package com.kawamura.todo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Article(
    var title: String,
    @ManyToOne var author: BlogUser,
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null
){
    override fun toString(): String {
        return "Article(title: $title, author: $author, addedAt: $addedAt, id: $id)"
    }
}

@Entity
class BlogUser(
    var login: String,
    var firstName: String,
    var lastName: String,
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null
){
    override fun toString(): String {
        return "BlogUser(login: $login, firstName: $firstName, lastName: $lastName, id: $id)"
    }
}