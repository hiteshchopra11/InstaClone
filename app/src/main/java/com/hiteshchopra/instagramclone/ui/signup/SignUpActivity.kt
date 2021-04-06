package com.hiteshchopra.instagramclone.ui.signup

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.ActivitySignUpBinding
import com.hiteshchopra.instagramclone.ui.base.ActivityNavigator
import com.hiteshchopra.instagramclone.ui.base.BaseActivity
import com.hiteshchopra.instagramclone.ui.login.LoginActivity
import com.hiteshchopra.instagramclone.utils.emptyEmailToast
import com.hiteshchopra.instagramclone.utils.emptyPasswordToast
import com.hiteshchopra.instagramclone.utils.invalidEmailToast
import com.hiteshchopra.instagramclone.utils.shortPasswordToast
import com.hiteshchopra.instagramclone.utils.toastMessage

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
                viewModel.validateEmailPassword(email, password)
                validationResultAndSignUp(email, password)
            }
        }
    }


    private fun validationResultAndSignUp(email: String, password: String) {
        viewModel.validateState.observe(this, { validationState ->
            when (validationState) {
                is SignUpValidateState.EmptyEmail ->
                    emptyEmailToast()
                is SignUpValidateState.EmptyPassword ->
                    emptyPasswordToast()
                is SignUpValidateState.InvalidEmail ->
                    invalidEmailToast()
                is SignUpValidateState.ShortPassword ->
                    shortPasswordToast()
                is SignUpValidateState.Valid -> {
                    viewModel.firebaseSignUp(email, password)
                    firebaseSignUpResult()
                }
            }
        })
    }

    private fun firebaseSignUpResult() {
        viewModel.signUpState.observe(this, { signUpState ->
            when (signUpState) {
                is SignUpViewState.Loading -> {
                    handleDataLoadingUi(true)
                }
                is SignUpViewState.Success -> {
                    handleDataLoadingUi(false)
                    toastMessage(getString(R.string.signed_up_successfully))
                    finishSignUpActivity()
                }
                is SignUpViewState.Error -> {
                    handleDataLoadingUi(false)
                    Snackbar.make(
                        binding.viewSignUpActivity,
                        "Error Occurred",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    toastMessage(signUpState.error?.message.toString())
                }
            }
        })
    }

    private fun handleDataLoadingUi(loading: Boolean) {
        with(binding) {
            pbSignUp.isVisible = loading
        }
    }

    private fun finishSignUpActivity() {
        ActivityNavigator.finishActivityWithAnimation(
            R.anim.slide_right_in,
            R.anim.slide_right_out,
            this
        )
        val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
        overridePendingTransition(0, 0)
        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
        startActivity(intent)
    }
}