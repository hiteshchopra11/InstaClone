package com.hiteshchopra.data.sources

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.SafeResult

interface IFirebaseSignUpDataSource {
    suspend fun firebaseSignUp(
        username: String,
        password: String,
    ): SafeResult<FirebaseUser>
}