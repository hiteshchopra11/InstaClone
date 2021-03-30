package com.hiteshchopra.data.listener

interface FirebaseListener {
    fun signUpSuccess(email: String, password: String)
    fun signUpFailure(exception: Exception, email: String, password: String)
    fun logInSuccess(email: String, password: String)
    fun logInFailure(exception: Exception, email: String, password: String)
}