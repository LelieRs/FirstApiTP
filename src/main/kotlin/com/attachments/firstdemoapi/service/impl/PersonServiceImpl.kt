package com.attachments.firstdemoapi.service.impl

import com.attachments.firstdemoapi.client.BookClient
import com.attachments.firstdemoapi.client.dto.VolumeInfo
import com.attachments.firstdemoapi.controller.dto.PersonInput
import com.attachments.firstdemoapi.exceptions.NotFoundException
import com.attachments.firstdemoapi.model.*
import com.attachments.firstdemoapi.model.personStrategy.Doctor
import com.attachments.firstdemoapi.repository.PersonRepository
import com.attachments.firstdemoapi.service.PersonService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(@Autowired  private var personRepository: PersonRepository, @Autowired  private var bookClient: BookClient): PersonService {


    private val log = KotlinLogging.logger {}

    override fun addPerson(personInput: PersonInput): Person {
        log.info("Creating ${personInput.name}.")
        val person: Person = createPerson(personInput)
        val personSaved = personRepository.savePerson(person)
        log.info("${person.name} has been created.")
        return personSaved
    }

    override fun findAllPersons(): List<Person> {
        log.info("Searching for all the persons saved...")
        val result = personRepository.findAllPersons()
        log.info("Persons found.")
        return result
    }

    override fun findPersonByDni(dni: Int): Person {
        log.info("The person with ID ${dni} will be sought.")
        return personRepository.findPersonByDni(dni)
    }

    override fun updatePerson(person: Person): Person {
        log.info("Updating ${person.dni}'s data...")
        val personUpdated = personRepository.savePerson(person)
        log.info("The person with ID ${person.dni} has been updated successfully.")
        return personUpdated
    }

    override fun deletePersonByDni(dni: Int): Unit {
        log.info("The person with ID ${dni} will be deleted.")
        personRepository.deletePersonByDni(dni)
        log.info("The person with ID ${dni} has been deleted successfully.")
    }


    override fun findPersonsByAge(age: Int): List<Person> {
        log.info("looking for people with $age years old...")
        val peopleFound = personRepository.findPersonsByAge(age)
        log.info("People with the age of $age have been found. People Bodies: $peopleFound.")
        return peopleFound
    }

    override fun findPersonsByAgeBetween(ageFrom: Int, ageTo: Int): List<Person> {
        log.info("looking for people between $ageFrom and $ageTo years old...")
        val peopleFound = personRepository.findPersonsByAgeBetween(ageFrom, ageTo)
        log.info("People with the age between $ageFrom and $ageTo years old have been found. People Bodies: $peopleFound.")
        return peopleFound
    }

    override fun findPersonsByNameStartingWith(nameStartedWith: String): List<Person> {
        log.info("looking for people with the initials $nameStartedWith...")
        val peopleFound = personRepository.findPersonsByNameStartingWith(nameStartedWith)
        log.info("People with their name started with $nameStartedWith have been found. People Bodies: $peopleFound.")
        return peopleFound
    }

    private fun createPerson(personInput: PersonInput): Person {
        val book: Book = createBook(personInput.isbn)

        return Person(
            personInput.name,
            personInput.lastName,
            personInput.dni,
            personInput.age,
            personInput.movies,
            book,
            personInput.professionType,
            personInput.money
        )
    }

     private fun createBook(isbn: String): Book {
        val bookResponse = bookClient.getBookResponse(isbn)
        val volumeInfo: VolumeInfo = bookResponse.items.get(0).volumeInfo

        return Book(
            isbn,
            volumeInfo.authors.get(0),
            volumeInfo.description,
            volumeInfo.publisher,
            volumeInfo.publishedDate,
            volumeInfo.title,
        )
    }

    override fun work(dni:Int){
        log.info("making the person with DNI ${dni} make some money...")
        val person = personRepository.findPersonByDni(dni)
        val strategy = getStrategy(person)
        strategy.work(person)
        updatePerson(person)
        log.info("the person with DNI ${dni} have now ${person.money} dollars.")
    }

    override fun switchProfession(dni:Int, newProfession: ProfessionTypeEnum) {
        log.info("the person with DNI ${dni} is going to change of carreer.")
        val person = personRepository.findPersonByDni(dni)
        person.professionType = newProfession
        updatePerson(person)
        log.info("the person with DNI ${dni} is now a ${person.professionType}.")
    }

    private fun getStrategy(person: Person): JobsType{
        val actualJob = JobsTypeStrategy().strategies[person.professionType]
        if (actualJob != null){
            return actualJob
        }else{
            throw NotFoundException("the given profession type ${person.professionType} doesn't exist.")
        }
    }

}