package com.attachments.firstdemoapi.repository

import com.attachments.firstdemoapi.model.Person

interface PersonRepository {

    fun savePerson(person: Person): Boolean

    fun findAllPersons(): MutableMap<Int, Person>

    fun findPersonByDni(personDni: Int): Person?

    fun updatePerson(person: Person): Boolean

    fun deletePersonByDni(dni: Int): Boolean
}