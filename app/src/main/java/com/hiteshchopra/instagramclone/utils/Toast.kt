package com.hiteshchopra.instagramclone.utils

import android.content.Context
import android.widget.Toast
import com.hiteshchopra.instagramclone.R


object Toast {
    fun Context.emptyEmailToast() {
        Toast.makeText(this, R.string.enter_email, Toast.LENGTH_SHORT).show()
    }

    fun Context.emptyPasswordToast() {
        Toast.makeText(this, R.string.enter_password, Toast.LENGTH_SHORT).show()
    }

    fun Context.invalidEmailToast() {
        Toast.makeText(this, R.string.incorrect_email, Toast.LENGTH_SHORT).show()
    }

    fun Context.shortPasswordToast() {
        Toast.makeText(this, R.string.short_password, Toast.LENGTH_SHORT).show()
    }

    fun Context.toastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}