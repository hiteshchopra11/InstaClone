package com.hiteshchopra.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.FirebaseSafeResult
import com.hiteshchopra.data.repository.FirebaseRepo
import com.hiteshchopra.domain.model.User

class UseCaseFirebaseSignUp(
    private val firebaseRepo: FirebaseRepo
) : BaseUseCase<FirebaseSafeResult<FirebaseUser>, User> {
    override suspend fun perform(
        executableParam: User
    ): FirebaseSafeResult<FirebaseUser> {
        return firebaseRepo.firebaseSignUp(
            email = executableParam.username,
            password = executableParam.password
        )
    }
}