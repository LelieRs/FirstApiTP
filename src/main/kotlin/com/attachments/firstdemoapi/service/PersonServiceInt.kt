package com.attachments.firstdemoapi.service

import com.attachments.firstdemoapi.model.Person

interface PersonServiceInt {

        fun addPerson(person : Person): String

        fun findAllPersons(): MutableMap<Int, Person>

        fun findPersonByDni(dni: Int): Person?

        fun updatePerson(person: Person): Boolean

        fun deletePersonByDni(dni: Int): Boolean
}