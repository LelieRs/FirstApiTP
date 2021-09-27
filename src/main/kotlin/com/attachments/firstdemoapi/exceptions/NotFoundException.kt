package com.attachments.firstdemoapi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(override val message: String = ""): RuntimeException(message)
