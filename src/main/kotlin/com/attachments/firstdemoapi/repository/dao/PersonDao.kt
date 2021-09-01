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

    fun save(person: Person): Boolean{
        personMap[person.dni]= person
        return true
    }

    fun findAllPersons(): MutableMap<Int, Person> {
        return personMap
    }

    fun findByDni(dni: Int): Person?{
        return personMap[dni]
    }

    fun updatePerson(person: Person): Boolean{
       log.info("hola, estoy en updatePerson ${person.dni}")
        val personToUpdate = personMap[person.dni]
        personToUpdate?.name = person.name
        personToUpdate?.lastName = person.lastName
        personToUpdate?.age = person.age
        personMap[person.dni] = personToUpdate!!
        return true
    }

    fun deletePersonByDni(dni: Int): Boolean{
       personMap.remove(dni)
        return true
    }
}