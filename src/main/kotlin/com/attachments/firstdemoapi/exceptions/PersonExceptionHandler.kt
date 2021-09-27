package com.attachments.firstdemoapi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler

class PersonExceptionHandler{

    @ExceptionHandler(NotFoundException::class)
    fun NotFoundException(ex: NotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(ex.message, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND)
    }

    data class ErrorResponse(
        val message: String?,
        val statusCode: HttpStatus
    )
}