package com.example.movieapp.ui.popular

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.Movie
import com.example.movieapp.data.Response
import com.example.movieapp.model.MovieRepository
import com.example.movieapp.network.NetworkService
import retrofit2.Call
import javax.security.auth.callback.Callback

class PopularViewModel : ViewModel() {

    private var liveDataPopularList = MutableLiveData<MutableList<Movie>>()
    private var liveDataRatedList = MutableLiveData<MutableList<Movie>>()
    private var liveData = MutableLiveData<String>()

    private var repository: MovieRepository = MovieRepository(NetworkService.getInstance())

    fun getPopularList(): MutableLiveData<MutableList<Movie>>{
        return liveDataPopularList
    }

    fun getPopularMovieList(){
        repository.getMoviesPopular().enqueue(object : retrofit2.Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.isSuccessful){
                    val movies = response.body()
                    liveDataPopularList.value = movies?.results
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.i("Error", "onFailure: ${t.message}")
            }
        })
    }

    fun getRatedList(): MutableLiveData<MutableList<Movie>>{
        return liveDataRatedList
    }

    fun getRatedMovieList(){
        repository.getMoviesRated().enqueue(object : retrofit2.Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.isSuccessful){
                    val movies = response.body()
                    liveDataRatedList.value = movies?.results
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.i("Error", "onFailure: ${t.message}")
            }
        })
    }

    fun getSpecificString() : MutableLiveData<String>{
        return liveData
    }
}
