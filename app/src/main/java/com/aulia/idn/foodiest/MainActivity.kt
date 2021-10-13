package com.aulia.idn.foodiest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.aulia.idn.foodiest.Fragment.FavoriteFragment
import com.aulia.idn.foodiest.Fragment.HomeFragment
import com.aulia.idn.foodiest.Fragment.LocationFragment
import com.aulia.idn.foodiest.Fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId) {
            R.id.nav_home -> {
                val fragment = HomeFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_location -> {
                val fragment = LocationFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_favorite -> {
                val fragment = FavoriteFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                val fragment = ProfileFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fm, fragment, fragment::class.java.simpleName)
            .addToBackStack(null).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //utk nge hapus action bar
        supportActionBar?.hide()

        nav_main.setOnNavigationItemSelectedListener ( onNavigationItemSelectedListener )

        val defaultMainView = HomeFragment.defaultFragment()
        addFragment(defaultMainView)
    }
}
