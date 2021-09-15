package com.attachments.firstdemoapi.model

import javax.persistence.*

@Entity
data class Book (
    @Id
    val isbn: String)
