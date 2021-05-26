package com.example.movieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.Movie
import com.example.movieapp.data.Utils
import com.example.movieapp.ui.popular.PopularViewModel

class MovieAdapter(private val viewModel: PopularViewModel,
                   private val context: Context,
                   private val movieList: MutableList<Movie>,
                   private val listener: OnMovieClickListener)
    : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val moviePoster: ImageView = itemView.findViewById(R.id.moviePoster)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieDesc: TextView = itemView.findViewById(R.id.movieDesc)
        val movieRating: RatingBar = itemView.findViewById(R.id.movieRating)

        fun bind(movie: Movie){
            //TODO ViewModel binding
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (v == itemView){
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.movieTitle.text = movieList[position].original_title
        holder.movieDesc.text = movieList[position].overview
        Glide.with(context).load(R.drawable.poster).into(holder.moviePoster)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

interface OnMovieClickListener{
    fun onItemClick(position: Int)
}