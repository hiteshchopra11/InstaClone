package com.hiteshchopra.instagramclone.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // try catch block to hide Action bar
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setupNavigationComponents()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity(1)
    }

    private fun setupNavigationComponents() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration =
            AppBarConfiguration(
                setOf(
                    R.id.homeScreen,
                    R.id.searchScreen,
                    R.id.reelsScreen,
                    R.id.likedScreen,
                    R.id.accountScreen
                )
            )

        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
    }
}