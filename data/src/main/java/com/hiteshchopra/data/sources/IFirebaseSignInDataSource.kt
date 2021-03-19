package com.hiteshchopra.data.sources

import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.SafeResult

interface IFirebaseSignInDataSource {
    suspend fun firebaseSignIn(
        username: String,
        password: String,
    ): SafeResult<FirebaseUser>
}