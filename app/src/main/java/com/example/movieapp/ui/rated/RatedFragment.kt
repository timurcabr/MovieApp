package com.example.movieapp.ui.rated

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.adapters.OnMovieClickListener
import com.example.movieapp.databinding.FragmentRatedBinding

class RatedFragment : Fragment(), OnMovieClickListener {
    private var _binding: FragmentRatedBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RatedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRatedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, "Rated fragment", Toast.LENGTH_SHORT).show()
        configureRecyclerView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(RatedViewModel::class.java)
    }

    private fun configureRecyclerView(){
        //TODO Should call adapter to show Movies
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}