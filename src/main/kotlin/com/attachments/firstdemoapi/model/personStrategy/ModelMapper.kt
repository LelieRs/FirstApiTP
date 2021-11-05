package com.attachments.firstdemoapi.model.personStrategy

import com.attachments.firstdemoapi.controller.dto.MovieInput
import com.attachments.firstdemoapi.controller.dto.PersonInput
import com.attachments.firstdemoapi.model.Movie
import com.attachments.firstdemoapi.model.Person

object ModelMapper {

    fun entityFromInput(personInput: PersonInput): Person {

        return Person(
            personInput.name,
            personInput.lastName,
            personInput.dni,
            personInput.age,
            personInput.professionType,
            personInput.money
        )
    }

    fun entityFromInput(movieInput: MovieInput): Movie {

         return Movie(
             movieInput.name,
             movieInput.director,
             movieInput.category,
             movieInput.price
         )
    }

    fun movieImputToMovie(movieInputList:List<MovieInput>): List<Movie>
       /* =
         movieInputList.stream().map {
            movieInput -> entityFromInput(movieInput)
        }.toList()*/
    {
        var list = mutableListOf<Movie>()
        for( movieInput in movieInputList){
            list.add(entityFromInput(movieInput))
        }
        return list
    }




}