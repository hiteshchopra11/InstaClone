package com.hiteshchopra.data.sources

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.SafeResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class FirebaseSignInDataSource(
    private val auth: FirebaseAuth,
    private val dispatcher: CoroutineDispatcher
) :
    IFirebaseSignInDataSource {
    override suspend fun firebaseSignIn(
        username: String,
        password: String,
    ): SafeResult<FirebaseUser> {
        return withContext(dispatcher) {
            val firebaseUser: FirebaseUser?
            try {
                auth.signInWithEmailAndPassword(
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