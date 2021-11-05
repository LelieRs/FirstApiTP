package com.attachments.firstdemoapi.model

import com.attachments.firstdemoapi.controller.dto.MovieInput
import javax.persistence.*

@Entity
data class Person(
    val name: String,
    val lastName: String,
    @Id
    @Column(name = "person_id")
    val dni: Int,
    val age: Int,
    var professionType: ProfessionTypeEnum,
    var money: Long,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var movies: MutableList<Movie> = mutableListOf(),
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    var book: Book? = null
)

enum class ProfessionTypeEnum{ DOCTOR, ENGINEER, POLICE_OFFICER}

