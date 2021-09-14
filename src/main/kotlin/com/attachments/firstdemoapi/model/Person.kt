package com.attachments.firstdemoapi.model

import javax.persistence.*

@Entity
@Table (name = "person")
data class Person(
    var name:String,
    var lastName:String,
    @Id
    val dni:Int,
    var age:Int,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "person_id")
    var moviesList: List<Movie>,
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "person_id")
    var book: Book)
