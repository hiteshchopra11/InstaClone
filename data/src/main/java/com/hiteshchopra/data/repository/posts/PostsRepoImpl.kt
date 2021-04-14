package com.hiteshchopra.data.repository.posts

import android.util.Log
import androidx.room.withTransaction
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.PostsDB
import com.hiteshchopra.data.local.entity.PostsEntity
import com.hiteshchopra.data.remote.posts.source.IPostsRemoteDataSource
import com.hiteshchopra.data.utils.networkBoundResource
import kotlinx.coroutines.flow.Flow

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
                    postsDao.deleteAllPosts()
                    postsDao.insertMulPosts(posts)
            })
    }
}