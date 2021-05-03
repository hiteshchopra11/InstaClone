package com.hiteshchopra.data.utils

import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import com.hiteshchopra.data.local.posts.entity.PostsEntity
import com.hiteshchopra.data.local.profile.entity.ProfileEntity
import com.hiteshchopra.data.local.stories.entity.StoriesEntity
import com.hiteshchopra.data.remote.notifications.model.NotificationList
import com.hiteshchopra.data.remote.posts.model.PostList
import com.hiteshchopra.data.remote.profile.model.ProfileResponse
import com.hiteshchopra.data.remote.stories.model.StoriesList

fun PostList.toPostsEntity(): List<PostsEntity> {
    return this.map { postResponse ->
        PostsEntity(
            postResponse.commentsCount,
            postResponse.postImage,
            postResponse.storiesImage,
            postResponse.likesCount,
            postResponse.location,
            postResponse.name
        )
    }
}

fun NotificationList.toNotificationEntity(): List<NotificationEntity> {
    return this.map { notificationResponse ->
        NotificationEntity(
            notificationResponse.heading,
            notificationResponse.id,
            notificationResponse.image,
            notificationResponse.notification,
            notificationResponse.time
        )
    }
}

fun StoriesList.toStoriesEntity(): List<StoriesEntity> {
    return this.map { storiesResponse ->
        StoriesEntity(
            storiesResponse.image,
            storiesResponse.name
        )
    }
}

fun ProfileResponse.toProfileEntity(): ProfileEntity {
    return ProfileEntity(
        this.username,
        this.followers_count,
        this.following_count,
        this.id,
        this.posts,
        this.posts_count,
        this.profile_bio,
        this.profile_name,
        this.profile_pic,
        this.reels,
        this.stories,
        this.tagged
    )
}

//fun ProfileResponse.toProfile(): Profile {
//    return Profile(
//        this.username,
//        this.followers_count,
//        this.following_count,
//        this.id,
//        this.posts_count,
//        this.profile_bio,
//        this.profile_name,
//        this.profile_pic,
//    )
//}
//
//fun ProfileResponse.toProfileStories(): List<ProfileStories> {
//    val stories = this.stories
//    return stories.map { stories ->
//        ProfileStories(stories)
//    }
//}
//
//fun ProfileResponse.toProfilePosts(): List<ProfilePosts> {
//    val posts = this.posts
//    return posts.map { posts ->
//        ProfilePosts(posts)
//    }
//}
//
//fun ProfileResponse.toProfileReels(): List<ProfileReels> {
//    val reels = this.reels
//    return reels.map { reels ->
//        ProfileReels(reels)
//    }
//}
//
//fun ProfileResponse.toProfileTagged(): List<ProfileTagged> {
//    val tagged = this.tagged
//    return tagged.map { tagged ->
//        ProfileTagged("1","1","")
//    }
//}

