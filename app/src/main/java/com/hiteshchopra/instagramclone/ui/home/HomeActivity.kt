package com.hiteshchopra.instagramclone.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hiteshchopra.instagramclone.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishActivity(1)
    }
}