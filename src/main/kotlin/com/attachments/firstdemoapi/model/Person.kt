package com.attachments.firstdemoapi.model

data class Person (var name:String, var lastName:String, val dni:Int, var age:Int, var moviesList: List<Movie>, var book: Book)

