package com.attachments.firstdemoapi.client

import com.attachments.firstdemoapi.client.dto.BookResponse
import com.attachments.firstdemoapi.restTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class BookClient() {

    private val restTemplate: RestTemplate = restTemplate()

    @Value("\${books.host}")
    val host: String = ""

    fun getBookResponse( isbn: String): BookResponse {
        val url = host + "/books/v1/volumes?q=isbn:" + isbn
        val response = restTemplate.getForEntity(url, BookResponse::class.java)
        return response.body!!
    }
}


