package com.attachments.firstdemoapi.model

import javax.persistence.*

@Entity
@Table (name = "movie")
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String,
    var director: String,
    var category: String,
    var price: Int

)