package com.example.movieapp.network

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.Movie

interface Repo {
    fun getMovieList() : MutableList<Movie>
    //TODO Only now it is String, then will be Movie object
    fun getSpecificMovie() : String
}