package com.hiteshchopra.data.sources

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.SafeResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class FirebaseSignUpDataSource(
    private val auth: FirebaseAuth,
    private val dispatcher: CoroutineDispatcher
) :
    IFirebaseSignUpDataSource {
    override suspend fun firebaseSignUp(
        username: String,
        password: String,
    ): SafeResult<FirebaseUser> {
        return withContext(dispatcher) {
            val firebaseUser: FirebaseUser?
            try {
                auth.createUserWithEmailAndPassword(
                    username, password
                ).await()
                firebaseUser = auth.currentUser
            } catch (e: Exception) {
                return@withContext SafeResult.Failure(e)
            }
            return@withContext SafeResult.Success(firebaseUser)
        }
    }
}