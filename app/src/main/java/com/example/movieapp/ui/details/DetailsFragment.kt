package com.example.movieapp.ui.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.Movie
import com.example.movieapp.databinding.FragmentDetailsBinding
import com.example.movieapp.network.Utils

class DetailsFragment : Fragment() {

    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        val movie = bundle?.getSerializable("movie") as Movie
        binding.apply {
            Log.i("data", movie.toString())
            movieTitle.text = movie.title
            movieOriginalTitle.text = movie.original_title
            movieOverview.text = movie.overview
            movieRelease.text = movie.release_date
            movieRatingItem.text = movie.vote_average.toString()
            context?.let { Glide.with(it).load(Utils.IMAGE_URL+movie.backdrop_path).into(moviePoster) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}