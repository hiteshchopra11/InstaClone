package com.hiteshchopra.instagramclone.utils

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hiteshchopra.instagramclone.utils.Validity.isInvalidEmail
import com.hiteshchopra.instagramclone.utils.Validity.isShortPassword
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ValidityTest {

    @Test
    fun empty_email_fail() {
        val result = ""
        assert(result.isInvalidEmail())
    }

    @Test
    fun invalid_email_format_fail() {
        val result = "testrandom"
        assert(result.isInvalidEmail())
    }

    @Test
    fun valid_email_format_pass() {
        val result = "testrandom@xyz.com"
        assert(!result.isInvalidEmail())
    }

    @Test
    fun empty_password_fail() {
        val result = ""
        assert(result.isShortPassword())
    }

    @Test
    fun short_password_fail() {
        val result = "123"
        assert(result.isShortPassword())
    }

    @Test
    fun valid_password_pass() {
        val result = "123323234"
        assert(!result.isShortPassword())
    }
}