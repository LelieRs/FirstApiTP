package com.attachments.firstdemoapi.repository.dao

import com.attachments.firstdemoapi.model.JobsTypeStrategy
import com.attachments.firstdemoapi.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDaoJpa: JpaRepository <Person, Int> {

    fun findPeopleByAge(age: Int):List<Person>

    fun findPersonsByAgeBetween(ageFrom: Int, ageTo: Int): List<Person>

    fun findPersonsByNameStartingWith(nameStartedWith: String): List<Person>

}