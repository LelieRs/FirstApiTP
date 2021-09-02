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


    override fun savePerson(person: Person): Boolean {
        log.info("Estás en PersonRepositoryImpl - fun savePerson -> Se guardarán los datos de ${person.name}.")
        val result = personDao.save(person)
        return result
    }

    override fun findAllPersons(): MutableMap<Int, Person> {
        log.info("Estás en PersonRepositoryImpl - fun findAllPersons -> Se ha realizará la búsqueda de todas las personas existentes en el repositorio.")
        return personDao.findAllPersons()
    }

    override fun findPersonByDni(personDni: Int): Person? {
        log.info("b\"Estás en PersonRepositoryImpl - fun findPersonByDni -> Se realizará la búsqueda del DNI ${personDni}.")
        return personDao.findByDni(personDni)
    }

    override fun updatePerson(person: Person): Boolean {
        log.info("\"Estás en PersonRepositoryImpl - fun updatePerson -> Se modificarán los datos de ${person.name}.")
        return personDao.updatePerson(person)
    }

    override fun deletePersonByDni(dni: Int): Boolean {
        log.info("Estás en PersonRepositoryImpl - fun deletePersonByDni -> Será eliminada del repositorio la persona con DNI ${dni}.")
        return personDao.deletePersonByDni(dni)
    }
}