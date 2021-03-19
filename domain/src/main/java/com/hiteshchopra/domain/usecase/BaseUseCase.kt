package com.hiteshchopra.domain.usecase

import com.google.firebase.auth.FirebaseAuth

interface BaseUseCase<out Result, in ExecutableParam> {
    /**
     * Perform an operation.
     *  Will throw an exception by default, if not implemented but invoked.
     *
     * @param params
     * @return
     */
    suspend fun perform(executableParam: ExecutableParam): Result = throw NotImplementedError()
}