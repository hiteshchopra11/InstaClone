package com.hiteshchopra.instagramclone.ui.signup

import android.content.Intent
import android.os.Bundle
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.ActivitySignUpBinding
import com.hiteshchopra.instagramclone.ui.base.BaseActivity
import com.hiteshchopra.instagramclone.ui.login.LoginActivity

class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpVM>() {
    override fun getViewModelClass(): Class<SignUpVM> = SignUpVM::class.java
    override fun layoutId(): Int = R.layout.activity_sign_up

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addListeners()
    }

    private fun addListeners() {
        with(binding) {
            tvSignIn.setOnClickListener {
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                overridePendingTransition(0, 0)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
            }
            layoutUsernamePassword.btnFirebaseLoginSignup.setText(R.string.sign_up)
        }
    }
}