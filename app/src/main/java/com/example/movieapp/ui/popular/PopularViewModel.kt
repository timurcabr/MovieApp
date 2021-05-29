package com.example.movieapp.ui.popular

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.Movie
import com.example.movieapp.network.MovieRepository

class PopularViewModel : ViewModel() {

    private var liveDataPopularList = MutableLiveData<MutableList<Movie>>()
    private var liveDataRatedList = MutableLiveData<MutableList<Movie>>()
    private var liveData = MutableLiveData<String>()

    private var repository: MovieRepository = MovieRepository()

    fun getPopularList(): MutableLiveData<MutableList<Movie>>{
        return liveDataPopularList
    }

    fun getPopularMovieList(){
        liveDataPopularList.value = repository.getPopularMovieList()
    }

    fun getRatedList(): MutableLiveData<MutableList<Movie>>{
        return liveDataRatedList
    }

    fun getRatedMovieList(){
        liveDataRatedList.value = repository.getRatedMovieList()
    }

    fun getSpecificString() : MutableLiveData<String>{
        return liveData
    }

    fun getSpecificItem(position: Int){
        liveData.value = repository.getSpecificMovie()
    }

}
