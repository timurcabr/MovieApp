package com.example.movieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.Movie
import com.example.movieapp.data.Utils

class MovieAdapter(private val context: Context,
                   private val movieList: MutableList<Movie>,
                   private val listener: OnMovieClickListener)
    : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val moviePoster: ImageView = itemView.findViewById(R.id.moviePoster)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieDesc: TextView = itemView.findViewById(R.id.movieDesc)
        val movieRating: RatingBar = itemView.findViewById(R.id.movieRating)

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
        holder.movieTitle.text = movieList[position].title
        holder.movieDesc.text = movieList[position].overview
        holder.movieRating.rating = movieList[position].vote_average.toFloat()
        Glide.with(context).load(Utils.IMAGE_URL+movieList[position].poster_path).into(holder.moviePoster)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

interface OnMovieClickListener{
    fun onItemClick(position: Int)
}