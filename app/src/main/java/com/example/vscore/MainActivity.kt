package com.example.vscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.vscore.Organizer.ui.CreateRoomFragment
import com.example.vscore.Organizer.ui.OrganizerHomeFragment
import com.example.vscore.Organizer.ui.OrganizerProfileFragment
import com.example.vscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val fragmentManager = supportFragmentManager
    lateinit var binding: ActivityMainBinding

    private val home = OrganizerHomeFragment()
    private val createMatch = CreateRoomFragment()
    private val profile = OrganizerProfileFragment()
    private var activeFragment: Fragment = home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.fragment_container)
        addFragments()
        showSelectedFragmentListener()
        binding.bottomNavigation.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun addFragments() {
        fragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, home, "home")
            add(R.id.fragment_container, createMatch, "create").hide(createMatch)
            add(R.id.fragment_container, profile, "profile").hide(profile)
        }.commit()
    }

    private fun showSelectedFragmentListener() {
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(home).commit()
                    activeFragment = home
                    true
                }
                R.id.navigation_room -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(createMatch)
                        .commit()
                    activeFragment = createMatch
                    true
                }
                R.id.navigation_profile -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(profile)
                        .commit()
                    activeFragment = profile
                    true
                }
                else -> false
            }
        }
    }
}