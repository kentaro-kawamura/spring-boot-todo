package com.kawamura.todo

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
interface PersonRepository: PagingAndSortingRepository<Person, Long>, CrudRepository<Person, Long> {
    fun findByLastName(@Param("name") name: String): Person
    fun findByFirstName(@Param("name") name: String): Person
}

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
//interface PersonRepository: PagingAndSortingRepository<Person, Long>{
//}