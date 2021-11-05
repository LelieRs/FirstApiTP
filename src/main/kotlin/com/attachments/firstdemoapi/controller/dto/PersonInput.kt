package com.attachments.firstdemoapi.controller.dto

import com.attachments.firstdemoapi.model.ProfessionTypeEnum

data class PersonInput (
    val name: String,
    val lastName: String,
    val dni: Int,
    val age: Int,
    var professionType: ProfessionTypeEnum,
    var money: Long,
    val isbn: String,
    val movies: List<MovieInput>)