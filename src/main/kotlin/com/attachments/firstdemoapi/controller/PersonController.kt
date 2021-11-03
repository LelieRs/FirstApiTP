package com.attachments.firstdemoapi.controller

import com.attachments.firstdemoapi.controller.dto.PersonInput
import com.attachments.firstdemoapi.exceptions.BadRequestException
import com.attachments.firstdemoapi.model.Person
import com.attachments.firstdemoapi.model.ProfessionTypeEnum
import com.attachments.firstdemoapi.service.PersonService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class PersonController (@Autowired var personService: PersonService){
    private val log = KotlinLogging.logger {}

    @PostMapping("/persons")
    fun generatePerson (@RequestBody personInput: PersonInput): ResponseEntity<Person> {
        return ResponseEntity(personService.addPerson(personInput), HttpStatus.OK)
    }

   /*
    otra forma de hacerlo sería:

    @GetMapping("/persons")
    fun findPersonsByParameters(@RequestParam(required = false) ageFrom: Int?, @RequestParam(required = false) ageTo: Int?): ResponseEntity<List<Person>>{
        val people: List<Person> = when{

            ageFrom != null && ageTo != null -> personService.findPersonsByAgeBetween(ageFrom, ageTo)
            ageFrom != null && ageTo == null -> personService.findPersonsByAge(ageFrom)
            ageFrom == null && ageTo == null -> personService.findAllPersons()
            else -> throw BadRequestException("Bad Request Exception")
        }
        return ResponseEntity(people, HttpStatus.OK)
    }*/

    @GetMapping("/persons")
    fun personsFilter(@RequestParam parameters: Map<String, String>): ResponseEntity<List<Person>>{
        log.info("the parameters are $parameters")

            val people: List<Person>? = when{

                parameters.isEmpty() -> personService.findAllPersons()
                parameters.containsKey("nameStartedWith") -> personService.findPersonsByNameStartingWith(parameters["nameStartedWith"]!!)
                parameters.containsKey("age") -> personService.findPersonsByAge(parameters["age"]!!.toInt())
                parameters.containsKey("ageFrom") && parameters.containsKey("ageTo") -> personService.findPersonsByAgeBetween(
                    parameters["ageFrom"]!!.toInt(),
                    parameters["ageTo"]!!.toInt()
                )
                else -> throw BadRequestException("Bad Request Exception")
            }
            return ResponseEntity(people, HttpStatus.OK)
        }


    @GetMapping("/persons/{dni}")
    fun findPersonById(@PathVariable dni: Int): ResponseEntity<Person?> {
        return ResponseEntity(personService.findPersonByDni(dni), HttpStatus.OK)
    }

    @PutMapping("/persons")
    fun updatePerson(@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity(personService.updatePerson(person), HttpStatus.OK)
    }

    @DeleteMapping("/persons/{dni}")
    fun deletePersonByDni(@PathVariable dni: Int): ResponseEntity<Unit>{
        return ResponseEntity(personService.deletePersonByDni(dni), HttpStatus.OK)
    }

    @PostMapping("persons/{dni}/work") //borrar work
    fun work (@PathVariable dni: Int): ResponseEntity<Unit> {
        return ResponseEntity(personService.work(dni), HttpStatus.OK)
    }

    @PostMapping("persons/{dni}/{newProfession}")
    fun switchProfession (@PathVariable dni: Int, @PathVariable newProfession: ProfessionTypeEnum): ResponseEntity<Unit> {
        return ResponseEntity(personService.switchProfession(dni, newProfession), HttpStatus.OK)
    }



}


