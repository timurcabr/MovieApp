package com.example.movieapp.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.Movie

class MovieRepository : Repo{

    override fun getPopularMovieList() = mutableListOf(
        Movie("Mortal Kombat", 4.6, "2020-05-13"),
        Movie("Tom Clancy's Without Remorse", 4.6, "2020-05-13"),
        Movie("Those Who Wish Me Dead", 4.6, "2020-05-13"))

    override fun getRatedMovieList() = mutableListOf(
        Movie("Spider-Man", 4.6, "2020-05-13"),
        Movie("Avengers - Final", 4.6, "2020-05-13"),
        Movie("Freedom Writers", 4.6, "2020-05-13"))

    override fun getSpecificMovie() = "Movie item clicked"
}