package com.attachments.firstdemoapi.controller

import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.service.PersonServiceInt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/firstapi")
class PersonController (@Autowired var personService: PersonServiceInt){


    @PostMapping("/persons")
    fun generatePerson (@RequestBody person: Person): ResponseEntity<String> {
        return ResponseEntity(personService.addPerson(person), HttpStatus.OK)
    }

    @GetMapping("/persons")
    fun findAllPersons(): ResponseEntity <MutableMap<Int, Person>>{
        val personList = personService.findAllPersons()
        return ResponseEntity(personService.findAllPersons(), HttpStatus.OK)
    }

    @GetMapping("/persons/{dni}")
    fun findPersonById(@PathVariable dni: Int): ResponseEntity<Person?>? {
        return ResponseEntity(personService.findPersonByDni(dni), HttpStatus.OK)
    }

    @PutMapping("/persons")
    fun updatePerson(@RequestBody person: Person): ResponseEntity<Boolean> {
        return ResponseEntity(personService.updatePerson(person), HttpStatus.OK)
    }

    @DeleteMapping("/persons/{dni}")
    fun deletePersonByDni(@PathVariable dni: Int): ResponseEntity<Boolean>{
        return ResponseEntity(personService.deletePersonByDni(dni), HttpStatus.OK)
    }


}