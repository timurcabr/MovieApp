package com.example.movieapp.network

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.Movie

interface Repo {
    fun getPopularMovieList() : MutableList<Movie>
    fun getRatedMovieList() : MutableList<Movie>
    fun getSpecificMovie() : String
}