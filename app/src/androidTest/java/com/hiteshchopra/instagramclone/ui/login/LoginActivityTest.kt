package com.hiteshchopra.instagramclone.ui.login

import android.Manifest
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.ui.home.HomeActivity
import com.hiteshchopra.instagramclone.ui.signup.SignUpActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class LoginActivityTest{
    @get:Rule
    var activityScenarioRule = activityScenarioRule<LoginActivity>()


    @get:Rule
    var permissionRule: GrantPermissionRule =
        GrantPermissionRule.grant(Manifest.permission.INTERNET)

    private val repeatEmail = "repeat@gmail.com"
    private val correctEmail = "12345@gmail.com"
    private val correctPassword = "12345678"
    private val wrongPassword = "test123"

    @Test
    fun correct_email_password_opens_home_activity(){
        Espresso.onView((ViewMatchers.withId(R.id.et_username)))
            .perform(ViewActions.typeText(correctEmail))

        Espresso.onView(ViewMatchers.withId(R.id.et_password))
            .perform(ViewActions.typeText(correctPassword))

        Espresso.closeSoftKeyboard()
        Thread.sleep(1000)
        Intents.init()
        Espresso.onView(ViewMatchers.withId(R.id.btn_firebase_login_signup))
            .perform(ViewActions.click())
        Thread.sleep(3000)

        Intents.intended(
            IntentMatchers.hasComponent(HomeActivity::class.java.name),
            (Intents.times(1))
        )

        Intents.release()
    }

    //Clicking on Sign Up textview opens SignUpActivity
    @Test
    fun sign_up_textview_click_open_sign_up_activity() {
        Intents.init()
        Espresso.onView(ViewMatchers.withId(R.id.tv_sign_up)).perform(ViewActions.click())
        Thread.sleep(3000)
        Intents.intended(
            IntentMatchers.hasComponent(SignUpActivity::class.java.name),
            (Intents.times(1))
        )

        Intents.release()
    }
}