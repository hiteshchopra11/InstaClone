package com.hiteshchopra.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stories(
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String
) : Parcelable