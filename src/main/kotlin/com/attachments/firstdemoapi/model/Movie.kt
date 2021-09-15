package com.attachments.firstdemoapi.model

import javax.persistence.*

@Entity
data class Movie(
    val name: String,
    val director: String,
    val category: String,
    val price: Int,
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int? = null
)