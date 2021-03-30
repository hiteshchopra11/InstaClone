package com.hiteshchopra.data.repository

import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.SafeResult

interface FirebaseRepo {
    suspend fun firebaseLogin(email: String, password: String): SafeResult<FirebaseUser>
    suspend fun firebaseSignUp(email: String, password: String): SafeResult<FirebaseUser>
}