package com.attachments.firstdemoapi.repository.dao

import com.attachments.firstdemoapi.model.Person
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
@Component
class PersonDao {
    private val log = KotlinLogging.logger {}

    private var personMap = mutableMapOf<Int, Person>()

    fun save (person: Person): Person? {
        personMap[person.dni] = person
        return personMap[person.dni]
    }

    fun findAllPersons(): List<Person> {
        // return ArrayList(personMap.values)
        return personMap.values.toList()
    }

    fun findByDni(dni: Int): Person?{
        return personMap[dni]
    }

    fun updatePerson(person: Person): Person{
       log.info("hola, estoy en updatePerson ${person.dni}")
        val personToUpdate = personMap[person.dni]
        personToUpdate?.name = person.name
        personToUpdate?.lastName = person.lastName
        personToUpdate?.age = person.age
        personToUpdate?.moviesList = person.moviesList
        personToUpdate?.book = person.book
        personMap[person.dni] = personToUpdate!!
        return person
    }

    fun deletePersonByDni(dni: Int): Unit{
       personMap.remove(dni)
    }
}