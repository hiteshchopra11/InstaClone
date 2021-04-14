package com.hiteshchopra.instagramclone.useCaseTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.FirebaseSafeResult
import com.hiteshchopra.data.repository.firebase.FirebaseRepo
import com.hiteshchopra.domain.model.User
import com.hiteshchopra.domain.usecase.UseCaseFirebaseSignUp
import com.hiteshchopra.instagramclone.BaseTest
import com.hiteshchopra.instagramclone.injection.component.TestAppComponent
import io.mockk.coEvery
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

class UseCaseSignUpTest : BaseTest() {

    @Inject
    lateinit var mockRepository: FirebaseRepo

    @Inject
    lateinit var mockFirebaseUser: FirebaseUser


    private lateinit var useCaseFirebaseSignUp: UseCaseFirebaseSignUp
    override fun setup() {
        super.setup()
        useCaseFirebaseSignUp = UseCaseFirebaseSignUp(mockRepository)
    }

    override fun injectIntoDagger(testAppComponent: TestAppComponent) {
        testAppComponent.inject(this)
    }

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun valid_request_returns_success() {
        runBlocking {
            val user = User("valid@gmail.com", "12345678")
            coEvery {
                mockRepository.firebaseSignUp(any(), any())
            } returns FirebaseSafeResult.Success(mockFirebaseUser)
            val result = useCaseFirebaseSignUp.perform(user)
            assert(result is FirebaseSafeResult.Success)
        }
    }

    @Test
    fun invalid_request_returns_fail() {
        runBlocking {
            val user: User = User("valid@gmail.com", "12345678")
            coEvery {
                mockRepository.firebaseSignUp(any(), any())
            } returns FirebaseSafeResult.Failure()
            val result = useCaseFirebaseSignUp.perform(user)
            assert(result is FirebaseSafeResult.Failure)
        }
    }
}