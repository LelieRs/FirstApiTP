package com.attachments.firstdemoapi.model.personStrategy

import com.attachments.firstdemoapi.controller.dto.PersonInput
import com.attachments.firstdemoapi.model.ProfessionTypeEnum
import com.attachments.firstdemoapi.service.PersonService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class DoctorTest (@Autowired private val personService: PersonService){

    /*  @Test
      fun work() {
          val randomBook = Book("9781501182099", "Scary Movie", "whoever", "whoeverBis","05/18/1900", "comedy")
          val doctor1 = Doctor("Terry", "Jeffords", 47864279, 42, listOf(), randomBook, 300) //asignar 300 de dinero inicial
          val doctor2 = doctor1.work()
          assertEquals(800, doctor2.money)
      }
      //ctr-alt-o

     */

    @Test //test Corregido
    fun switchProfession() {

        var person = PersonInput("Ross", "Geller", 47864279, 35, listOf(), "9781501182099", ProfessionTypeEnum.DOCTOR,0)
        personService.addPerson(person)
        personService.work(47864279)
        personService.switchProfession(47864279, ProfessionTypeEnum.ENGINEER)
        personService.work(47864279)
        val person2 = personService.findPersonByDni(47864279)

        assertEquals(1500, person2.money)
    }
}