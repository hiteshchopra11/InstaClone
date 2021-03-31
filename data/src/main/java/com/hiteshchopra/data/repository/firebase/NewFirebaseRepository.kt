package com.hiteshchopra.data.repository.firebase

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.listener.FirebaseListener
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.concurrent.Executor


class NewFirebaseRepository(
    private val mAuth: FirebaseAuth,
    private val dispatcher: CoroutineDispatcher,
    private val observer: FirebaseListener
) : Executor {
    fun signUp(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful)
                    observer.signUpSuccess(email, password)
                else
                    observer.signUpFailure(task.exception!!, email, password)
            })
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

    override fun execute(runnable: Runnable?) {
        Thread(runnable).start()
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