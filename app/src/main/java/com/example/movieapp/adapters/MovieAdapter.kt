package com.example.movieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.Movie
import com.example.movieapp.databinding.PosterItemBinding

class MovieAdapter(
    private val category: String,
    private val context: Context,
    private val movieList: MutableList<Movie>,
    private val listener: OnMovieClickListener
) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    inner class MovieHolder(val binding: PosterItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
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
                movieTitleItem.text = movieList[position].original_title
                movieReleaseItem.text = movieList[position].release_date
                movieRatingItem.text = movieList[position].vote_average.toString()

                if (category == "Popular") {
                    Glide.with(context).load(R.drawable.poster).into(moviePosterItem)
                } else {
                    Glide.with(context).load(R.drawable.poster_two).into(moviePosterItem)
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

interface OnMovieClickListener {
    fun onItemClick(position: Int)
}