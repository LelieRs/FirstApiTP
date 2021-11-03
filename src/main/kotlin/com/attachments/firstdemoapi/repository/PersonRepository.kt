package com.attachments.firstdemoapi.repository

import com.attachments.firstdemoapi.model.Person
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository {

    fun savePerson(person: Person): Person

    fun findAllPersons(): List<Person>

    fun findPersonByDni(personDni: Int): Person

    fun deletePersonByDni(dni: Int): Unit

    fun findPersonsByAge(age: Int): List<Person>

    fun findPersonsByAgeBetween(ageFrom: Int, ageTo: Int): List<Person>

    fun findPersonsByNameStartingWith(nameStartedWith: String): List<Person>
}