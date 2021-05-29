package com.example.movieapp.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.Movie

class MovieRepository : Repo{

    override fun getMovieList(): MutableList<Movie> {
        //TODO Should return list of movies from API, but now I will send just mock
        val movieList = mutableListOf<Movie>()
        movieList.add(Movie("Mortal Kombat", "Боец смешанных единоборств знает"))
        movieList.add(Movie("Tom Clancy's Without Remorse", "Боец смешанных единоборств знает"))
        movieList.add(Movie("Those Who Wish Me Dead", "Боец смешанных единоборств знает"))
        return movieList
    }

    override fun getSpecificMovie(): String {
        return "Movie item clicked"
    }

}