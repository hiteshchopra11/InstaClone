package com.hiteshchopra.instagramclone.ui.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.hiteshchopra.domain.model.User
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.ActivitySignUpBinding
import com.hiteshchopra.instagramclone.ui.base.ActivityNavigator
import com.hiteshchopra.instagramclone.ui.base.BaseActivity
import com.hiteshchopra.instagramclone.ui.login.LoginActivity
import com.hiteshchopra.instagramclone.utils.Validity

class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpVM>() {
    override fun getViewModelClass(): Class<SignUpVM> = SignUpVM::class.java
    override fun layoutId(): Int = R.layout.activity_sign_up
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addListeners()
    }

    private fun addListeners() {
        with(binding) {
            layoutUsernamePassword.btnFirebaseLoginSignup.setText(R.string.sign_up)
            tvSignIn.setOnClickListener {
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                overridePendingTransition(0, 0)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
            }
            layoutUsernamePassword.btnFirebaseLoginSignup.setOnClickListener {
                val email = binding.layoutUsernamePassword.etUsername.text.toString()
                val password = binding.layoutUsernamePassword.etPassword.text.toString()
                validateAndSignUpFirebase(email, password)
            }
        }
    }

    private fun validateAndSignUpFirebase(email: String, password: String) {
        val user = User(email, password)
        when (Validity.isEmailValid(email) && Validity.isPasswordValid(password)) {
            true -> {
                viewModel.firebaseSignUp(user)
                firebaseSignUpResult()
            }
            false -> {
                if (!Validity.isEmailValid(email)) {
                    Toast.makeText(
                        this@SignUpActivity,
                        "Please enter a valid email",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@SignUpActivity,
                        "Please enter a password of minimum 6 characters",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun firebaseSignUpResult() {
        viewModel.viewState.observe(this, Observer { state ->
            when (state) {
                is SignUpViewState.Loading -> {
                    handleDataLoadingUi(true)
                }
                is SignUpViewState.Success -> {
                    handleDataLoadingUi(false)
                    Toast.makeText(
                        this,
                        "Signed Up Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    ActivityNavigator.finishActivityWithAnimation(
                        R.anim.slide_right_in,
                        R.anim.slide_right_out,
                        this
                    )
                }
                is SignUpViewState.Error -> {
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
        }
    }
}