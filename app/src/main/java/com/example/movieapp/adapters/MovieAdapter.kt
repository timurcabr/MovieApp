package com.example.movieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.data.Movie
import com.example.movieapp.databinding.PosterItemBinding
import com.example.movieapp.network.Utils

class MovieAdapter(
    private val context: Context,
    private val movieList: MutableList<Movie>,
    private val listener: OnMovieClickListener
) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    inner class MovieHolder(val binding: PosterItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener{
                listener.onItemClick(movieList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = PosterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        with(holder) {
            binding.apply {
                movieTitleItem.text = movieList[position].title
                movieReleaseItem.text = movieList[position].release_date
                movieRatingItem.text = movieList[position].vote_average.toString()
                Glide.with(context).load(Utils.IMAGE_URL + movieList[position].poster_path).into(moviePosterItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

interface OnMovieClickListener {
    fun onItemClick(movie: Movie)
}