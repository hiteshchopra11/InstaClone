package com.hiteshchopra.instagramclone.ui.login

import android.os.Bundle
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.ActivityLoginBinding
import com.hiteshchopra.instagramclone.ui.base.BaseActivity
import android.content.Intent
import com.hiteshchopra.instagramclone.ui.signup.SignUpActivity


class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addListeners()
    }

    private fun addListeners(){
        with(binding){
            signUp.setOnClickListener {
                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                overridePendingTransition(0, 0)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
            }
        }
    }

    override fun layoutId(): Int = R.layout.activity_login
}