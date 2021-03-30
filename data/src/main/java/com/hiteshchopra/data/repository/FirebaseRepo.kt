package com.hiteshchopra.data.repository

import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.FirebaseSafeResult

interface FirebaseRepo {
    suspend fun firebaseLogin(email: String, password: String): FirebaseSafeResult<FirebaseUser>
    suspend fun firebaseSignUp(email: String, password: String): FirebaseSafeResult<FirebaseUser>
}