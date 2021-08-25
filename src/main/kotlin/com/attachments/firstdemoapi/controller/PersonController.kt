package com.attachments.firstdemoapi.controller

import com.attachments.firstdemoapi.model.Person
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/firstapi")
class PersonController {

    @PostMapping("/people")
        fun generatePerson (@RequestBody person: Person): ResponseEntity<Person> {
            return ResponseEntity(person, HttpStatus.OK)
    }


}
