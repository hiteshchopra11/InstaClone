package com.hiteshchopra.instagramclone.repository

import android.app.Activity
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.hiteshchopra.data.listener.FirebaseListener
import com.hiteshchopra.data.repository.firebase.CFirebaseRepository
import com.hiteshchopra.data.repository.firebase.NewFirebaseRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import java.util.concurrent.Executor


class RepositoryTest : FirebaseListener {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var newFirebaseRepository: NewFirebaseRepository
    private lateinit var dispatcher: CoroutineDispatcher

    private lateinit var cFirebaseRepository: CFirebaseRepository

    private lateinit var successTask: Task<AuthResult>
    private lateinit var failureTask: Task<AuthResult>

    @MockK
    private lateinit var mAuth: FirebaseAuth

    private var logInResult: Int = UNDEF
    private var signUpResult: Int = UNDEF

    companion object {
        private const val SUCCESS = 1
        private const val FAILURE = -1
        private const val UNDEF = 0
    }

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        successTask = getSuccessAuthResultListener()
        failureTask = getFailureAuthResultListener()
        dispatcher = Dispatchers.Unconfined
        newFirebaseRepository = NewFirebaseRepository(mAuth, dispatcher, this)
        cFirebaseRepository = CFirebaseRepository(mAuth, dispatcher, this)
        logInResult = UNDEF
        signUpResult = UNDEF
    }

    private fun getSuccessAuthResultListener() = object : Task<AuthResult>() {
        override fun isComplete(): Boolean = true
        override fun isSuccessful(): Boolean = true
        override fun isCanceled(): Boolean = false
        override fun getResult(): AuthResult? = null
        override fun <X : Throwable?> getResult(p0: Class<X>): AuthResult? = null
        override fun getException(): Exception? = null
        override fun addOnSuccessListener(p0: OnSuccessListener<in AuthResult?>): Task<AuthResult> =
            null!!

        override fun addOnSuccessListener(
            p0: Executor,
            p1: OnSuccessListener<in AuthResult>
        ): Task<AuthResult> = null!!

        override fun addOnSuccessListener(
            p0: Activity,
            p1: OnSuccessListener<in AuthResult>
        ): Task<AuthResult> = null!!

        override fun addOnFailureListener(p0: OnFailureListener): Task<AuthResult> = null!!

        override fun addOnFailureListener(
            p0: Executor,
            p1: OnFailureListener
        ): Task<AuthResult> = null!!

        override fun addOnFailureListener(
            p0: Activity,
            p1: OnFailureListener
        ): Task<AuthResult> = null!!

        override fun addOnCompleteListener(
            onCompleteListener: OnCompleteListener<AuthResult>
        ): Task<AuthResult> {
            onCompleteListener.onComplete(successTask)
            return successTask
        }
    }

    private fun getFailureAuthResultListener() = object : Task<AuthResult>() {
        override fun isComplete(): Boolean = true
        override fun isSuccessful(): Boolean = true
        override fun isCanceled(): Boolean = false
        override fun getResult(): AuthResult? = null
        override fun <X : Throwable?> getResult(p0: Class<X>): AuthResult? = null
        override fun getException(): Exception? = null
        override fun addOnSuccessListener(p0: OnSuccessListener<in AuthResult?>): Task<AuthResult> =
            null!!

        override fun addOnSuccessListener(
            p0: Executor,
            p1: OnSuccessListener<in AuthResult>
        ): Task<AuthResult> = null!!

        override fun addOnSuccessListener(
            p0: Activity,
            p1: OnSuccessListener<in AuthResult>
        ): Task<AuthResult> = null!!

        override fun addOnFailureListener(p0: OnFailureListener): Task<AuthResult> = null!!

        override fun addOnFailureListener(
            p0: Executor,
            p1: OnFailureListener
        ): Task<AuthResult> = null!!

        override fun addOnFailureListener(
            p0: Activity,
            p1: OnFailureListener
        ): Task<AuthResult> = null!!

        override fun addOnCompleteListener(
            onCompleteListener: OnCompleteListener<AuthResult>
        ): Task<AuthResult> {
            onCompleteListener.onComplete(failureTask)
            return failureTask
        }
    }

    @Test
    fun signUpSuccess_test() {
        val email = "kwggdekes@gmail.com"
        val password = "hjhswgswhsw"
        runBlocking {
            coEvery { mAuth.createUserWithEmailAndPassword(email, password) }.returns(successTask)
            cFirebaseRepository.signUp(email, password)
            assert(signUpResult == 1)
        }
    }

    @Test
    fun signUpFail_test() {
        val email = "dfsgsgSgs"
        val password = "hjhswgswhsw"
        runBlocking {
            coEvery { mAuth.createUserWithEmailAndPassword(email, password) }.returns(failureTask)
            cFirebaseRepository.signUp(email, password)
            assert(signUpResult == -1)
        }
    }

    override fun signUpSuccess(email: String, password: String) {
        signUpResult = SUCCESS
    }

    override fun signUpFailure(exception: Exception, email: String, password: String) {
        signUpResult = FAILURE
    }

    override fun logInSuccess(email: String, password: String) {
        logInResult = SUCCESS
    }

    override fun logInFailure(exception: Exception, email: String, password: String) {
        logInResult = FAILURE
    }

}