package com.hiteshchopra.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.SafeResult
import com.hiteshchopra.data.repository.FirebaseRepo
import com.hiteshchopra.domain.model.User

class UseCaseFirebaseSignUp(
    private val firebaseRepo: FirebaseRepo
) : BaseUseCase<SafeResult<FirebaseUser>, User> {
    override suspend fun perform(
        executableParam: User
    ): SafeResult<FirebaseUser> {
        return firebaseRepo.firebaseSignUp(
            username = executableParam.username,
            password = executableParam.password
        )
    }
}