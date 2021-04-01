package com.hiteshchopra.instagramclone.ui.home

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.ActivityHomeBinding
import com.hiteshchopra.instagramclone.ui.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeVM>() {

    override fun getViewModelClass(): Class<HomeVM> = HomeVM::class.java
    override fun layoutId(): Int = R.layout.activity_home

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // try catch block to hide Action bar
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setupNavigationComponents()
    }


    private fun setupNavigationComponents() {
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
        binding.bottomNavigationView.setupWithNavController(navController)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity(1)
    }

}

