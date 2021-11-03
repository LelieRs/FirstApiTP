package com.attachments.firstdemoapi.service

import com.attachments.firstdemoapi.controller.dto.PersonInput
import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.model.ProfessionTypeEnum

interface PersonService {

        fun addPerson(personInput: PersonInput): Person

        fun findAllPersons(): List<Person>

        fun findPersonByDni(dni: Int): Person

        fun updatePerson(person: Person): Person

        fun deletePersonByDni(dni: Int): Unit

        fun findPersonsByAge(age: Int):List<Person>

        fun findPersonsByAgeBetween(ageFrom: Int, ageTo: Int):List<Person>

        fun findPersonsByNameStartingWith(nameStartedWith: String): List<Person>

        fun work(dni: Int)

        fun switchProfession(dni:Int, newProfession: ProfessionTypeEnum)

}