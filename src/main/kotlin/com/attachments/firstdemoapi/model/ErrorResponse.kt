package com.attachments.firstdemoapi.model

import org.springframework.http.HttpStatus
import java.sql.Timestamp

class ErrorResponse(
    val timestamp: Timestamp,
    val status: HttpStatus,
    val error: String?,
    val path: String)
