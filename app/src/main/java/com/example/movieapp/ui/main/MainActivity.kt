package com.example.movieapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.ui.popular.PopularFragment
import com.example.movieapp.ui.favorite.FavoriteFragment
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar?.apply {
                setDisplayShowHomeEnabled(true)
                setLogo(R.drawable.logo)
                setDisplayUseLogoEnabled(true)
            }
        }

        setFragment(PopularFragment())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.movies -> setFragment(PopularFragment())
                R.id.favorite -> setFragment(FavoriteFragment())
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search -> showSnackBar()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSnackBar() {
        Snackbar
            .make(binding.fragmentContainer, "Want to reload?", Snackbar.LENGTH_INDEFINITE)
            .setAction("Reload") { Toast.makeText(this@MainActivity, "Reloaded", Toast.LENGTH_SHORT).show()}
            .show()
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer.id, fragment)
            addToBackStack(null)
            commit()
        }
    }
}