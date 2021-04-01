package com.hiteshchopra.instagramclone.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.ActivityLoginBinding
import com.hiteshchopra.instagramclone.ui.base.ActivityNavigator
import com.hiteshchopra.instagramclone.ui.base.BaseActivity
import com.hiteshchopra.instagramclone.ui.home.HomeActivity
import com.hiteshchopra.instagramclone.ui.signup.SignUpActivity
import com.hiteshchopra.instagramclone.utils.emptyEmailToast
import com.hiteshchopra.instagramclone.utils.emptyPasswordToast
import com.hiteshchopra.instagramclone.utils.invalidEmailToast
import com.hiteshchopra.instagramclone.utils.shortPasswordToast
import com.hiteshchopra.instagramclone.utils.toastMessage


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
                viewModel.validateEmailPassword(email, password)
                validationResultAndSignIn(email, password)
            }
        }
    }


    private fun validationResultAndSignIn(email: String, password: String) {
        viewModel.validateState.observe(this, { validationState ->
            when (validationState) {
                is SignInValidateState.EmptyEmail ->
                    emptyEmailToast()
                is SignInValidateState.EmptyPassword ->
                    emptyPasswordToast()
                is SignInValidateState.InvalidEmail ->
                    invalidEmailToast()
                is SignInValidateState.ShortPassword ->
                    shortPasswordToast()
                is SignInValidateState.Valid -> {
                    viewModel.firebaseSignUp(email, password)
                    firebaseSignInResult()
                }
            }
        })
    }

    private fun firebaseSignInResult() {
        viewModel.loginState.observe(this, { loginState ->
            when (loginState) {
                is LoginViewState.Loading -> {
                    handleDataLoadingUi(true)
                }
                is LoginViewState.Success -> {
                    handleDataLoadingUi(false)
                    toastMessage(getString(R.string.signed_up_successfully))
                    ActivityNavigator.startActivity(
                        HomeActivity::class.java,
                        this
                    )
                }
                is LoginViewState.Error -> {
                    handleDataLoadingUi(false)
                    toastMessage(loginState.error?.message.toString())
                }
            }
        })
    }

    private fun handleDataLoadingUi(loading: Boolean) {
        with(binding) {
            pbSignIn.isVisible = loading
        }
    }

}