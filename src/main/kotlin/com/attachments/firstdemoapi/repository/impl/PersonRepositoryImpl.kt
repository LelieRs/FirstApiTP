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
        log.info("Saving ${person.name}'s data.")
        val result = personDao.save(person)
        log.info("${person.name}'s data has been saved successfully.")
        return result
    }

    override fun findAllPersons(): List<Person> {
        log.info("Searching for all the people saved in repository...")
        val result = personDao.findAllPersons()
        log.info("Persons found: ")
        return result
    }

    override fun findPersonByDni(personDni: Int): Person? {
        log.info("Searching for ${personDni}...")
        val person= personDao.findByDni(personDni)
        log.info("Person found.")
        return person
    }

    override fun deletePersonByDni(dni: Int): Unit {
        log.info("The person with ID ${dni} will be deleted.")
        val deletedPerson= personDao.deletePersonByDni(dni)
        log.info("The person with ID ${dni} has been deleted.")
        return deletedPerson
    }
}