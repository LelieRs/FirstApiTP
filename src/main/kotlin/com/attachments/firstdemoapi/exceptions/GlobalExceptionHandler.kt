package com.attachments.firstdemoapi.exceptions

import com.attachments.firstdemoapi.model.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.sql.Timestamp
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class GlobalExceptionHandler{

    @ExceptionHandler(NotFoundException::class)
    fun NotFoundException(ex: NotFoundException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(Timestamp(System.currentTimeMillis()), HttpStatus.NOT_FOUND, ex.message, request.requestURI), HttpStatus.NOT_FOUND)
    }


}