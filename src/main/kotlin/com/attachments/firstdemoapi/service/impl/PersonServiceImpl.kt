package com.attachments.firstdemoapi.service.impl

import com.attachments.firstdemoapi.exceptions.NotFoundException
import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.repository.PersonRepository
import com.attachments.firstdemoapi.service.PersonService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(@Autowired  private var personRepository: PersonRepository): PersonService {

    private val log = KotlinLogging.logger {}

    override fun addPerson(person: Person): Person {
        log.info("Creating ${person.name}.")
        val personSaved = personRepository.savePerson(person)
        log.info("${person.name} has been created.")
        return personSaved
    }

    override fun findAllPersons(): List<Person> {
        log.info("Searching for all the persons saved in repository...")
        val result = personRepository.findAllPersons()
        log.info("Persons found.")
        return result
    }

    override fun findPersonByDni(dni: Int): Person? {
        log.info("Searching for ${dni}...")
        val person =
            personRepository.findPersonByDni(dni) ?: throw NotFoundException("the person with ID $dni doesn't exist.")
        log.info("Person found.")
        return person
    }

    override fun updatePerson(person: Person): Person {
        log.info("Updating ${person.dni}'s data...")
        return personRepository.savePerson(person)
        log.info("The person with ID ${person.dni} has been updated successfully.")
    }

    override fun deletePersonByDni(dni: Int): Unit {
        log.info("The person with ID ${dni} will be deleted.")
        personRepository.deletePersonByDni(dni)
        log.info("The person with ID ${dni} has been deleted successfully.")
    }
}