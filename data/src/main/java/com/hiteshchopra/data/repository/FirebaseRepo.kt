package com.hiteshchopra.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.SafeResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

// todo repo would be prefix

class FirebaseRepo(
    private val dispatcher: CoroutineDispatcher,
    private val auth: FirebaseAuth
) {
    suspend fun firebaseLogin(
        username: String,
        password: String,
    ): SafeResult<FirebaseUser> {
        return withContext(dispatcher) {
            val firebaseUser: FirebaseUser?
            try {
                //Awaits for completion of the task without blocking a thread.
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

    suspend fun firebaseSignUp(
        username: String,
        password: String
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