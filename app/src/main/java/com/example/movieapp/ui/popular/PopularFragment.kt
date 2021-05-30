package com.example.movieapp.ui.popular

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.adapters.MovieAdapter
import com.example.movieapp.adapters.OnMovieClickListener
import com.example.movieapp.data.Movie
import com.example.movieapp.databinding.FragmentPopularBinding
import com.example.movieapp.ui.details.DetailsFragment

class PopularFragment : Fragment(), OnMovieClickListener {
    private var _binding : FragmentPopularBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PopularViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PopularViewModel::class.java)
        viewModel.getPopularMovieList()
        viewModel.getRatedMovieList()

        viewModel.getPopularList().observe(viewLifecycleOwner, {
            Log.i("Data", it.toString())
            configurePopularList(it)
        })

        viewModel.getRatedList().observe(viewLifecycleOwner, {
            configureRatedList(it)
        })
        Toast.makeText(context, "Popular fragment", Toast.LENGTH_SHORT).show()
    }

    private fun configurePopularList(movieList: MutableList<Movie>){
        binding.movieListPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.movieListPopular.setHasFixedSize(true)
        binding.movieListPopular.adapter = MovieAdapter("Popular", requireContext(), movieList, this)
    }

    private fun configureRatedList(movieList: MutableList<Movie>){
        binding.movieListRated.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.movieListRated.setHasFixedSize(true)
        binding.movieListRated.adapter = MovieAdapter("Rated", requireContext(), movieList, this)
    }

    override fun onItemClick(position: Int) {
        viewModel.getSpecificItem(position)
        viewModel.getSpecificString().observe(viewLifecycleOwner, {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, DetailsFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}