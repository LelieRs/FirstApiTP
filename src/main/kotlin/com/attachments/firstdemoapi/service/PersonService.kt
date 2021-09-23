package com.attachments.firstdemoapi.service

import com.attachments.firstdemoapi.controller.dto.PersonInput
import com.attachments.firstdemoapi.model.Person

interface PersonService {

        fun addPerson(personInput: PersonInput): Person

        fun findAllPersons(): List<Person>

        fun findPersonByDni(dni: Int): Person?

        fun updatePerson(person: Person): Person

        fun deletePersonByDni(dni: Int): Unit
}