package com.example.movieapp.ui.popular

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
    private var _binding: FragmentPopularBinding? = null
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
        viewModel.apply {
            getPopularMovieList()
            getRatedMovieList()

            getPopularList().observe(viewLifecycleOwner, {
                configurePopularList(it)
            })

            getRatedList().observe(viewLifecycleOwner, {
                configureRatedList(it)
            })
        }
    }

    private fun configurePopularList(movieList: MutableList<Movie>) {
        binding.movieListPopular.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = MovieAdapter(requireContext(), movieList, this@PopularFragment)
        }
    }

    private fun configureRatedList(movieList: MutableList<Movie>) {
        binding.movieListRated.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = MovieAdapter(requireContext(), movieList, this@PopularFragment)
        }
    }

    override fun onItemClick(movie: Movie) {
        viewModel.apply {
            getSpecificString().observe(viewLifecycleOwner, {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
        }
        parentFragmentManager.beginTransaction().apply {
            val bundle = Bundle()
            bundle.putSerializable("movie", movie)
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}