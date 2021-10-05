package com.attachments.firstdemoapi.repository.impl

import com.attachments.firstdemoapi.exceptions.NoContentException
import com.attachments.firstdemoapi.exceptions.NotFoundException
import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.repository.PersonRepository
import com.attachments.firstdemoapi.repository.dao.PersonDaoJpa
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

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

    override fun findPersonByDni(personDni: Int): Person {
        log.info("searching for $personDni's person in repository...")
        val personFound = personDaoJpa.findByIdOrNull(personDni)
            ?: throw NotFoundException("the person with ID $personDni doesn't exist.")
        log.info("The person with ID $personDni has been found in Repository. Person Body: $personFound.")
        return personFound
    }

    override fun deletePersonByDni(dni: Int): Unit {
        log.info("Deleting person with DNI $dni...")
        try {
            personDaoJpa.deleteById(dni)
        } catch (ex: EmptyResultDataAccessException) {
            throw NotFoundException("the person with ID $dni cannot be erased because it doesn't exist.")
        }
        log.info("The person with DNI $dni has been deleted from the repository.")
    }

    override fun findPersonsByAge(age: Int): List<Person> {
        log.info("Searching for persons with the age of $age...")
        val personList = personDaoJpa.findPeopleByAge(age)

        if (personList.isNotEmpty()){
           return personList
        } else {
           throw NoContentException("There are not people with the age $age registered in system.")
        }
    }

    override fun findPersonsByAgeBetween(ageFrom: Int, ageTo: Int): List<Person> {
        log.info("Searching for persons with the age informed...")
        val personList = personDaoJpa.findPersonsByAgeBetween(ageFrom, ageTo)

        if (personList.isNotEmpty()){
            return personList
        } else {
            throw NotFoundException("There are no people registered with the age within the indicated parameters in system.")
        }
    }

    override fun findPersonsByNameStartingWith(nameStartedWith: String): List<Person> {
        log.info("Searching for persons with name started with $nameStartedWith...")
        val personsFound = personDaoJpa.findPersonsByNameStartingWith(nameStartedWith)

        if (personsFound.isNotEmpty()){
            return personsFound
        }else {
            throw NoContentException("There are no people registered in system with name started in $nameStartedWith.")
        }
    }


}
