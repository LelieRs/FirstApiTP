package com.attachments.firstdemoapi.model

import javax.persistence.*

@Entity
@Table(name = "book")
data class Book (
    var name: String,
    @Id
    var isbn: String)
