package com.attachments.firstdemoapi.repository.impl

import com.attachments.firstdemoapi.exceptions.NotFoundException
import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.repository.PersonRepository
import com.attachments.firstdemoapi.repository.dao.PersonDao
import com.attachments.firstdemoapi.repository.dao.PersonDaoJpa
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Repository
class PersonRepositoryImpl (@Autowired  private val personDaoJpa: PersonDaoJpa): PersonRepository {

    private val log = KotlinLogging.logger {}


    override fun savePerson(person: Person): Person {
        log.info("saving $person's data in repository...")
        val personSaved = personDaoJpa.save(person)
        log.info("${person.name}'s data has been saved in repository / $personSaved")
        return personSaved
    }

    override fun findAllPersons(): List<Person> {
        log.info("Finding all the people saved in repository...")
        return personDaoJpa.findAll()
    }

    override fun findPersonByDni(personDni: Int): Person? {
        log.info("searching for $personDni's person in repository...")
        val personFound = personDaoJpa.findById(personDni).orElseThrow() ?: throw NotFoundException("the person with ID $personDni doesn't exist.")
        log.info("The person with ID $personDni has been found in Repository. Person Body: $personFound.")
        return personFound
    }

    override fun deletePersonByDni(dni: Int): Unit {
        log.info("Deleting person with DNI $dni...")
        personDaoJpa.deleteById(dni)
        log.info("The person with DNI $dni has been deleted from the repository.")
    }
}