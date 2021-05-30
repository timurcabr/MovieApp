package com.example.movieapp.data

data class Movie(val backdrop_path: String,
                 val id: Long,
                 val original_language: String,
                 val original_title: String,
                 val overview: String,
                 val popularity: Double,
                 val poster_path: String,
                 val release_date: String,
                 val title: String,
                 val vote_average: Double){

    constructor(original_title: String, vote_average: Double, release_date: String) : this("", 0, "", original_title, "", 0.0, "", release_date, "", vote_average)

}