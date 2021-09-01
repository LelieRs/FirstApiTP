package com.attachments.firstdemoapi.service

import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService( @Autowired  private var personRepository: PersonRepository) {

    fun addPerson(person : Person): String =
        "Estamos en PersonService -> addPerson y status " + personRepository.savePerson(person)

    fun findAllPersons(): MutableMap<Int, Person> =
        personRepository.findAllPersons()

    fun findPersonByDni(dni: Int): Person? =
        personRepository.findPersonByDni(dni)

    fun updatePerson(person: Person): Boolean =
        personRepository.updatePerson(person)

    fun deletePersonByDni(dni: Int): Boolean =
        personRepository.deletePersonByDni(dni)
}