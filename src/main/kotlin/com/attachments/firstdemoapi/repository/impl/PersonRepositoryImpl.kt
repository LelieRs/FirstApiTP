package com.attachments.firstdemoapi.repository.impl

import com.attachments.firstdemoapi.exceptions.NotFoundException
import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.repository.PersonRepository
import com.attachments.firstdemoapi.repository.dao.PersonDao
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonRepositoryImpl(@Autowired  private var personDao: PersonDao): PersonRepository {

    private val log = KotlinLogging.logger {}


    override fun savePerson(person: Person): Person {
        log.info("saving $person's data in repository...")
        val personSaved = personDao.save(person)
        log.info("${person.name}'s data has been saved in repository / $personSaved")
        return personSaved
    }

    override fun findAllPersons(): List<Person> {
        log.info("Finding all the people saved in repository...")
        return personDao.findAllPersons()
    }

    override fun findPersonByDni(personDni: Int): Person? {
        log.info("searching for $personDni's person in repository...")
        val personFound = personDao.findByDni(personDni) ?: throw NotFoundException("the person with ID $personDni doesn't exist.")
        log.info("The person ${personFound.name} with ID $personDni has been found in Repository. Person Body: $personFound.")
        return personFound
    }

    override fun deletePersonByDni(dni: Int): Unit {
        log.info("Deleting person with DNI $dni...")
        personDao.deletePersonByDni(dni)
        log.info("The person with DNI $dni has been deleted from the repository.")
    }
}