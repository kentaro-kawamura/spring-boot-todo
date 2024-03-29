package com.kawamura.todo

import org.apache.el.stream.Optional
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ArticleRepository: CrudRepository<Article, Long> {
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
//    override fun findById(id: Long): java.util.Optional<Article>

}

interface BlogUserRepository: CrudRepository<BlogUser, Long> {
    fun findByFirstName(firstName: String): BlogUser


}