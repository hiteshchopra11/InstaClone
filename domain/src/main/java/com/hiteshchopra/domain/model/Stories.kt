package com.hiteshchopra.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class Stories(
    val name: String,
    val image: String
)