package com.hiteshchopra.domain.mapper

import com.hiteshchopra.data.remote.posts.model.PostList

fun PostList.toPosts(): List<com.hiteshchopra.domain.model.Post> {
    return this.map { postResponse ->
        com.hiteshchopra.domain.model.Post(
            postResponse.commentsCount,
            postResponse.postImage,
            postResponse.storiesImage,
            postResponse.likesCount,
            postResponse.location,
            postResponse.name
        )
    }
}