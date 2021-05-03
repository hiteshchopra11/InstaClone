package com.hiteshchopra.domain.model

data class Profile(
    val username: String,
    val followers_count: Int,
    val following_count: Int,
    val id: String,
    val posts: List<String>,
    val posts_count: Int,
    val profile_bio: String,
    val profile_name: String,
    val profile_pic: String,
    val reels: List<String>,
    val stories: List<String>,
    val tagged: List<String>
)