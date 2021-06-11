package com.example.movieapp.model

import com.example.movieapp.data.Movie
import com.example.movieapp.network.NetworkService
import com.example.movieapp.network.Utils

class MovieRepository(private val retrofitService: NetworkService) : Repo {

    override fun getMoviesPopular() = retrofitService.getMovies(Utils.API_KEY, Utils.LANGUAGE, Utils.SORT_BY_POPULARITY)

    override fun getMoviesRated() = retrofitService.getMovies(Utils.API_KEY, Utils.LANGUAGE, Utils.SORT_BY_RATING)
}