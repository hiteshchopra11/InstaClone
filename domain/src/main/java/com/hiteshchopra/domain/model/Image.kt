package com.hiteshchopra.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val small: String,
) : Parcelable