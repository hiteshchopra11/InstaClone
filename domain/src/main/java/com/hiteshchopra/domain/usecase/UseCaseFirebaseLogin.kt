package com.hiteshchopra.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.SafeResult
import com.hiteshchopra.data.repository.FirebaseRepo
import com.hiteshchopra.data.repository.FirebaseRepoImpl
import com.hiteshchopra.domain.model.User

class UseCaseFirebaseLogin(
    private var firebaseRepo: FirebaseRepo
) : BaseUseCase<SafeResult<FirebaseUser>, User> {
    override suspend fun perform(executableParam: User): SafeResult<FirebaseUser> {
        return firebaseRepo.firebaseLogin(
            executableParam.username,
            executableParam.password
        )
    }
}


