package com.hiteshchopra.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.FirebaseSafeResult
import com.hiteshchopra.data.repository.FirebaseRepo
import com.hiteshchopra.domain.model.User

class UseCaseFirebaseLogin(
    private var firebaseRepo: FirebaseRepo
) : BaseUseCase<FirebaseSafeResult<FirebaseUser>, User> {
    override suspend fun perform(executableParam: User): FirebaseSafeResult<FirebaseUser> {
        return firebaseRepo.firebaseLogin(
            executableParam.username,
            executableParam.password
        )
    }
}


