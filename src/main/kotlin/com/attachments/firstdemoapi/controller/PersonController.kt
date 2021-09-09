package com.attachments.firstdemoapi.controller

import com.attachments.firstdemoapi.exceptions.NotFoundException
import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.service.PersonService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/firstapi")
class PersonController (@Autowired var personService: PersonService){
    private val log = KotlinLogging.logger {}

    @PostMapping("/persons")
    fun generatePerson (@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity(personService.addPerson(person), HttpStatus.OK)
    }

    @GetMapping("/persons")
    fun findAllPersons(): ResponseEntity <List<Person>>{
        val personList = personService.findAllPersons()
        return ResponseEntity(personService.findAllPersons(), HttpStatus.OK)
    }

    @GetMapping("/persons/{dni}")
    fun findPersonById(@PathVariable dni: Int): ResponseEntity<Person?> {
        var person: Person? = null
        var status = HttpStatus.OK
        try {
            person = personService.findPersonByDni(dni)
        }catch(e: NotFoundException) {
            log.info(e.message)
            status = HttpStatus.NOT_FOUND
        }
        return ResponseEntity(person, status)
    }

    @PutMapping("/persons")
    fun updatePerson(@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity(personService.addPerson(person), HttpStatus.OK)
    }

    @DeleteMapping("/persons/{dni}")
    fun deletePersonByDni(@PathVariable dni: Int): ResponseEntity<Unit>{
        return ResponseEntity(personService.deletePersonByDni(dni), HttpStatus.OK)
    }
}