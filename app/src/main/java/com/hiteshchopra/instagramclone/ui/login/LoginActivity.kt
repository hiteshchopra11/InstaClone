package com.hiteshchopra.instagramclone.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.domain.model.User
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.ActivityLoginBinding
import com.hiteshchopra.instagramclone.ui.base.ActivityNavigator
import com.hiteshchopra.instagramclone.ui.base.BaseActivity
import com.hiteshchopra.instagramclone.ui.home.HomeActivity
import com.hiteshchopra.instagramclone.ui.signup.SignUpActivity
import com.hiteshchopra.instagramclone.utils.Validity


class LoginActivity : BaseActivity<ActivityLoginBinding, LoginVM>() {
    override fun layoutId(): Int = R.layout.activity_login
    override fun getViewModelClass(): Class<LoginVM> = LoginVM::class.java
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addListeners()
    }

    private fun addListeners() {
        with(binding) {
            layoutUsernamePassword.btnFirebaseLoginSignup.setText(R.string.log_in)
            tvSignUp.setOnClickListener {
                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                overridePendingTransition(0, 0)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
            }

            layoutUsernamePassword.btnFirebaseLoginSignup.setOnClickListener {
                val email = binding.layoutUsernamePassword.etUsername.text.toString()
                val password = binding.layoutUsernamePassword.etPassword.text.toString()
                validateAndSignInFirebase(email, password)
            }
        }
    }

    private fun validateAndSignInFirebase(email: String, password: String) {
        var user= User(email,password)
        when (Validity.isEmailValid(email) && Validity.isPasswordValid(password)) {
            true -> {
                viewModel.firebaseSignIn(user)
                firebaseSignInResult()
            }
            false -> {
                if (!Validity.isEmailValid(email)) {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter a valid email",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter a password of minimum 6 characters",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun firebaseSignInResult() {
        viewModel.viewState.observe(this, Observer { state ->
            when (state) {
                is SignInViewState.Loading -> {
                    handleDataLoadingUi(true)
                }
                is SignInViewState.Success -> {
                    handleDataLoadingUi(false)
                    Toast.makeText(
                        this,
                        "Signed In Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    ActivityNavigator.startActivityWithAnimation(
                        HomeActivity::class.java,
                        R.anim.slide_left_in,
                        R.anim.slide_left_out,
                        this
                    )
                }
                is SignInViewState.Error -> {
                    handleDataLoadingUi(false)
                    Toast.makeText(
                        this,
                        "Error occurred ${state.error?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun handleDataLoadingUi(loading: Boolean) {
        with(binding) {
            pbSignUp.isVisible = loading
            layoutUsernamePassword.btnFirebaseLoginSignup.isEnabled = !loading
        }
    }
}