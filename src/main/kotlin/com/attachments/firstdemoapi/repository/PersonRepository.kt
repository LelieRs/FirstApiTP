package com.attachments.firstdemoapi.repository

import com.attachments.firstdemoapi.model.Person

interface PersonRepository {

    fun savePerson(person: Person): Person?

    fun findAllPersons(): List<Person>

    fun findPersonByDni(personDni: Int): Person?

    fun updatePerson(person: Person): Person

    fun deletePersonByDni(dni: Int): Unit

}