package com.hiteshchopra.domain.mapper

import com.hiteshchopra.data.remote.profile.model.ProfileResponse
import com.hiteshchopra.domain.model.Profile

fun ProfileResponse.toProfile(): Profile {
    return Profile(
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