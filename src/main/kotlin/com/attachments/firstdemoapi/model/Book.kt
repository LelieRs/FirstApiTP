package com.attachments.firstdemoapi.model

import javax.persistence.*

@Entity
data class Book (
    val name: String,
    @Id
    val isbn: String)
