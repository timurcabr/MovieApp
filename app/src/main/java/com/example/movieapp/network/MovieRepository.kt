package com.example.movieapp.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.Movie

class MovieRepository : Repo{

    override fun getPopularMovieList(): MutableList<Movie> {
        //TODO Should return list of movies from API, but now I will send just mock
        val movieList = mutableListOf<Movie>()
        movieList.add(Movie("Mortal Kombat", 4.6, "2020-05-13"))
        movieList.add(Movie("Tom Clancy's Without Remorse", 4.6, "2020-05-13"))
        movieList.add(Movie("Those Who Wish Me Dead", 4.6, "2020-05-13"))
        return movieList
    }

    override fun getRatedMovieList(): MutableList<Movie> {
        val movieList = mutableListOf<Movie>()
        movieList.add(Movie("Spider-Man", 4.6, "2020-05-13"))
        movieList.add(Movie("Avengers - Final", 4.6, "2020-05-13"))
        movieList.add(Movie("Freedom Writers", 4.6, "2020-05-13"))
        return movieList
    }

    override fun getSpecificMovie(): String {
        return "Movie item clicked"
    }
}