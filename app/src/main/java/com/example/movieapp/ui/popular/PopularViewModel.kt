package com.example.movieapp.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.Movie
import com.example.movieapp.network.MovieRepository

class PopularViewModel : ViewModel() {

    private var liveDataList = MutableLiveData<MutableList<Movie>>()
    private var liveData = MutableLiveData<String>()
    private var repository: MovieRepository = MovieRepository()

    fun getData(): MutableLiveData<MutableList<Movie>>{
        return liveDataList
    }

    fun getMovieList(){
        liveDataList.value = repository.getMovieList()
    }

    fun getSpecificString() : MutableLiveData<String>{
        return liveData
    }

    fun getSpecificItem(position: Int){
        liveData.value = repository.getSpecificMovie()
    }

}
