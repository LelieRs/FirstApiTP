package com.attachments.firstdemoapi.controller.dto

import com.attachments.firstdemoapi.model.Movie
import com.attachments.firstdemoapi.model.ProfessionTypeEnum

data class PersonInput (
    val name: String,
    val lastName: String,
    val dni: Int,
    val age: Int,
    val movies: List<Movie>,
    val isbn: String,
    var professionType: ProfessionTypeEnum,
    var money: Long)