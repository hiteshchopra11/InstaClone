package com.hiteshchopra.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.FirebaseSafeResult
import com.hiteshchopra.data.remote.posts.model.PostList
import com.hiteshchopra.data.remote.posts.source.IPostsDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

// todo repo would be prefix

class RepoImpl(
    private val dispatcher: CoroutineDispatcher,
    private val auth: FirebaseAuth,
    private val postsDataSource: IPostsDataSource
) : FirebaseRepo, PostsRepo {
    override suspend fun firebaseLogin(
        email: String,
        password: String,
    ): FirebaseSafeResult<FirebaseUser> {
        return withContext(dispatcher) {
            val firebaseUser: FirebaseUser?
            try {
                //Awaits for completion of the task without blocking a thread.
                auth.signInWithEmailAndPassword(
                    email, password
                ).await()
                firebaseUser = auth.currentUser
            } catch (e: Exception) {
                return@withContext FirebaseSafeResult.Failure(e)
            }
            return@withContext FirebaseSafeResult.Success(firebaseUser!!)
        }
    }

    override suspend fun firebaseSignUp(
        email: String,
        password: String
    ): FirebaseSafeResult<FirebaseUser> {
        return withContext(dispatcher) {
            val firebaseUser: FirebaseUser?
            try {
                auth.createUserWithEmailAndPassword(
                    email, password
                ).await()
                firebaseUser = auth.currentUser
            } catch (e: Exception) {
                return@withContext FirebaseSafeResult.Failure(e)
            }
            return@withContext FirebaseSafeResult.Success(firebaseUser!!)
        }
    }

    override suspend fun getPosts(): ApiSafeResult<PostList> {
        return postsDataSource.getPosts()
    }
}