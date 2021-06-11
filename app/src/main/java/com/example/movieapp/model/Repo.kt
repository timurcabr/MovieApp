package com.example.movieapp.model

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.Movie
import com.example.movieapp.data.Response
import retrofit2.Call

interface Repo {
    fun getMoviesPopular() : Call<Response>
    fun getMoviesRated() : Call<Response>
}