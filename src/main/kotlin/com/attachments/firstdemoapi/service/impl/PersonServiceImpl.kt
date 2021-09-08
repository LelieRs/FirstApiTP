package com.attachments.firstdemoapi.service.impl

import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.repository.PersonRepository
import com.attachments.firstdemoapi.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(@Autowired  private var personRepository: PersonRepository): PersonService {

    override fun addPerson(person : Person): Person =
       personRepository.savePerson(person)

    override fun findAllPersons(): List<Person> =
        personRepository.findAllPersons()

    override fun findPersonByDni(dni: Int): Person? =
        personRepository.findPersonByDni(dni)

    override fun deletePersonByDni(dni: Int): Unit =
        personRepository.deletePersonByDni(dni)
}