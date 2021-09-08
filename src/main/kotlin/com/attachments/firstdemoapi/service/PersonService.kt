package com.attachments.firstdemoapi.service

import com.attachments.firstdemoapi.model.Person

interface PersonService {

        fun addPerson(person : Person): Person

        fun findAllPersons(): List<Person>

        fun findPersonByDni(dni: Int): Person?

        fun deletePersonByDni(dni: Int): Unit
}