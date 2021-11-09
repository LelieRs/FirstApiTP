package com.attachments.firstdemoapi.model

import javax.persistence.*

@Entity
data class Person (
    val name: String,
    val lastName: String,
    @Id
    val dni: Int,
    val age: Int,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "person_id")
    val movies: List<Movie>,
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    val book: Book,
    @Enumerated(EnumType.STRING)
    var professionType: ProfessionTypeEnum,
    var money: Long)


enum class ProfessionTypeEnum{ DOCTOR, ENGINEER, POLICE_OFFICER}

