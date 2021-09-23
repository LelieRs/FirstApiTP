package com.attachments.firstdemoapi.model

import javax.persistence.*

@Entity
data class Book (
    @Id
    val isbn: String,
    val title: String,
    val authors: String,
    val publisher: String,
    val publishedDate: String,
    val category: String
)
