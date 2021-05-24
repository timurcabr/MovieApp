package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movieapp.fragments.PopularFragment
import com.example.movieapp.fragments.RatedFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    //TODO Ready to get started with Retrofit library!!!

    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.setLogo(R.drawable.logo)
            supportActionBar?.setDisplayUseLogoEnabled(true)
        }

        bottomNav = findViewById(R.id.bottomNavigationView)

        setFragment(PopularFragment())

        bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.popular -> setFragment(PopularFragment())
                R.id.rated -> setFragment(RatedFragment())
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }

}