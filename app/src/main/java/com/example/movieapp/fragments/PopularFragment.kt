package com.example.movieapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.adapters.OnMovieClickListener

class PopularFragment : Fragment(), OnMovieClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(context, "Popular fragment", Toast.LENGTH_SHORT).show()
        configureRecyclerView()
    }

    private fun configureRecyclerView(){
       //TODO Should call adapter to show Movies

    }

    override fun onItemClick(position: Int) {
        //TODO Should get details of movie and pass it to another fragment through arguments
    }
}