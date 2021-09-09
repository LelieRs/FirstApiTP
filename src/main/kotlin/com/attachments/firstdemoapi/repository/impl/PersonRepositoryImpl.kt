package com.attachments.firstdemoapi.repository.impl

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
        log.info("Saving person...")
        return personDao.save(person)
        log.info("Person saved successfully.")
    }


    override fun findAllPersons(): List<Person> {
        log.info("Finding all people...")
        return personDao.findAllPersons()
    }

    override fun findPersonByDni(personDni: Int): Person? {
        log.info("looking for $personDni's person in repository...")
        return personDao.findByDni(personDni)
    }

    override fun deletePersonByDni(dni: Int): Unit {
        log.info("Deleting person...")
        personDao.deletePersonByDni(dni)
        log.info("The person has been deleted from the repository.")
    }
}