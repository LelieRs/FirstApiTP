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
        log.info("Se ha guardado exitosamente los datos de ${person.name}.")
        val result = personDao.save(person)
        return result
    }

    override fun findAllPersons(): MutableMap<Int, Person> {
        log.info("Se ha realizado la búsqueda de todas las personas existentes en el repositorio.")
        return personDao.findAllPersons()
    }

    override fun findPersonByDni(personDni: Int): Person? {
        log.info("findPersonByDni = Se realizará la búsqueda del DNI ${personDni}.")
        return personDao.findByDni(personDni)
    }

    override fun updatePerson(person: Person): Boolean {
        log.info("Se ha modificado exitosamente los datos de ${person.name}.")
        return personDao.updatePerson(person)
    }

    override fun deletePersonByDni(dni: Int): Boolean {
        log.info("Ha sido eliminada del repositorio la persona con DNI ${dni}.")
        return personDao.deletePersonByDni(dni)
    }
}