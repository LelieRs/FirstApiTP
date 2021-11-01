package com.attachments.firstdemoapi.model.personStrategy

import com.attachments.firstdemoapi.model.Book
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DoctorTest {

    @Test
    fun work() {
        val randomBook = Book("9781501182099", "Scary Movie", "whoever", "whoeverBis","05/18/1900", "comedy")
        val doctor1 = Doctor("Terry", "Jeffords", 47864279, 42, listOf(), randomBook, 300) //asignar 300 de dinero inicial
        val doctor2 = doctor1.work()
        assertEquals(800, doctor2.money)
    }

    @Test
    fun switchProfession() {
        val randomBook = Book("9781501182099", "Scary Movie", "whoever", "whoeverBis","05/18/1900", "comedy")
        val doctor1 = Doctor("Ross", "Geller", 47864279, 35, listOf(), randomBook, 300) //asignar 300 de dinero inicial
        val doctor2 = doctor1.work()
        val doctor3 = doctor2.switchProfession("Engineer")
        val engineer = doctor3.work()

        assertEquals(2300, engineer.money)
    }
}