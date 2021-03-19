package com.hiteshchopra.data.repository

import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.SafeResult
import com.hiteshchopra.data.sources.IFirebaseSignInDataSource
import com.hiteshchopra.data.sources.IFirebaseSignUpDataSource

class FirebaseRepo(
    private val firebaseSignUpDataSource: IFirebaseSignUpDataSource,
    private val firebaseSignInDataSource: IFirebaseSignInDataSource,
) {

    suspend fun firebaseLogin(
        username: String,
        password: String,
    ): SafeResult<FirebaseUser> {
        return firebaseSignInDataSource.firebaseSignIn(
            username = username,
            password = password,
        )
    }

    suspend fun firebaseSignUp(
        username: String,
        password: String
    ): SafeResult<FirebaseUser> {
        return firebaseSignUpDataSource.firebaseSignUp(
            username = username,
            password = password
        )
    }
}