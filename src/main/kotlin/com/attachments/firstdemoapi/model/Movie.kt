package com.attachments.firstdemoapi.model

import javax.persistence.*

@Entity
data class Movie (

    val name: String,
    val director: String,
    val category: String,
    val price: Int,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id")
    var person: Person? = null
    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "movie_id")
    val id: Long = 0
}