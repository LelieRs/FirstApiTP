package com.attachments.firstdemoapi.model.personStrategy

import com.attachments.firstdemoapi.model.Book
import com.attachments.firstdemoapi.model.Movie
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.boot.autoconfigure.batch.JobExecutionEvent

internal class PoliceOfficerTest {

    @Test
    fun work() {
        val randomBook = Book("9781501182099", "Scary Movie", "whoever", "whoeverBis","05/18/1900", "comedy")
        val policeOfficer1 = PoliceOfficer("Terry", "Jeffords", 47864279, 42, listOf(), randomBook, 300) //asignar 300 de dinero inicial
        val policeOfficer2 = policeOfficer1.work()
        assertEquals(800, policeOfficer2.money)
    }

    @Test
    fun switchProfession() {
        val randomBook = Book("9781501182099", "Scary Movie", "whoever", "whoeverBis","05/18/1900", "comedy")
        val policeOfficer1 = PoliceOfficer("Terry", "Jeffords", 47864279, 42, listOf(), randomBook, 300) //asignar 300 de dinero inicial
        val policeOfficer2 = policeOfficer1.work()
        val policeOfficer3 = policeOfficer2.switchProfession("Engineer")
        val engineer = policeOfficer3.work()

        assertEquals(2300, engineer.money)
    }
}