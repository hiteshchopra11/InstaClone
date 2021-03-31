package com.hiteshchopra.data.repository.firebase

import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.listener.FirebaseListener
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class CFirebaseRepository(
    private val mAuth: FirebaseAuth,
    private val dispatcher: CoroutineDispatcher,
    private val observer: FirebaseListener
) {
    suspend fun signUp(email: String, password: String) {
        withContext(dispatcher) {
            try {
                mAuth.createUserWithEmailAndPassword(email, password)
                    .await()
                observer.signUpSuccess(email, password)
            } catch (e: Exception) {
                observer.signUpFailure(e, email, password)
            }
        }
    }

    suspend fun logIn(email: String, password: String) {
        withContext(dispatcher) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful)
                    observer.logInSuccess(email, password)
                else
                    observer.logInFailure(task.exception!!, email, password)
            }
        }
    }
}


//
//    suspend fun duplicateLogIn(email: String, password: String): FirebaseSafeResult<FirebaseUser> {
//        return suspendCancellableCoroutine<FirebaseSafeResult<FirebaseUser>> {
//            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
//                if (task.isSuccessful)
//                    it.resume(FirebaseSafeResult.Success(mAuth.currentUser!!))
//                else
//                    it.resumeWithException(task.exception as Throwable)
//            }
//        }
//    }