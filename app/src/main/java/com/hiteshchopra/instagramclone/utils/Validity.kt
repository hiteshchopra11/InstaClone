package com.hiteshchopra.instagramclone.utils

object Validity {
    fun String.isInvalidEmail(): Boolean {
        return !android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    fun String.isShortPassword(): Boolean {
        return this.length < 6
    }
}