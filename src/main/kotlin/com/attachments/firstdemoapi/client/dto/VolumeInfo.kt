package com.attachments.firstdemoapi.client.dto

data class VolumeInfo (
    val authors: List<String>,
    val categories: List<String>,
    val description: String,
    val industryIdentifiers: List<IndustryIdentifier>,
    val pageCount: Int,
    val publishedDate: String,
    val publisher: String,
    val title: String
)