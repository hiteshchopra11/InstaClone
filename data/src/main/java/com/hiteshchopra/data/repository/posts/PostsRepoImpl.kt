package com.hiteshchopra.data.repository.posts

import androidx.room.withTransaction
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.posts.PostsDB
import com.hiteshchopra.data.local.posts.entity.PostsEntity
import com.hiteshchopra.data.remote.posts.source.IPostsRemoteDataSource
import com.hiteshchopra.data.utils.networkBoundResource
import com.hiteshchopra.data.utils.toPostsEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class PostsRepoImpl(
    private val postsRemoteDataSource: IPostsRemoteDataSource,
    private val db: PostsDB
) : PostsRepo {
    private val postsDao = db.getPostsDao()
    override suspend fun getPosts(): Flow<ApiSafeResult<List<PostsEntity>>> {
        return networkBoundResource(
            query = { postsDao.getPosts() },
            fetch = { postsRemoteDataSource.getPosts() },
            saveFetchResult = { posts ->
                db.withTransaction {
                    postsDao.insertMulPosts(posts.toPostsEntity())
                }
            })
    }
}