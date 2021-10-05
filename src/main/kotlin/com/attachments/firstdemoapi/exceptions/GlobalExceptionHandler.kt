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

    @ExceptionHandler(BadRequestException::class)
    fun BadRequestException(ex: BadRequestException, request: HttpServletRequest): ResponseEntity<ErrorResponse>{
        return ResponseEntity(ErrorResponse(Timestamp(System.currentTimeMillis()), HttpStatus.BAD_REQUEST, ex.message, request.requestURI), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NoContentException::class)
    fun NoContentException(ex: NoContentException, request: HttpServletRequest): ResponseEntity<ErrorResponse>{
        return ResponseEntity(ErrorResponse(Timestamp(System.currentTimeMillis()), HttpStatus.NO_CONTENT, ex.message, request.requestURI), HttpStatus.NO_CONTENT)
    }
}