package com.hiteshchopra.instagramclone.ui.signup

import android.Manifest
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.ui.login.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SignUpActivityTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<SignUpActivity>()


    @get:Rule
    var permissionRule: GrantPermissionRule =
        GrantPermissionRule.grant(Manifest.permission.INTERNET)

    private val repeatEmail = "repeat@gmail.com"
    private val correctEmail = "repeat12345@gmail.com"
    private val correctPassword = "123456789"
    private val wrongPassword = "test123"


    //Correct email password opens LoginActivity
    @Test
    fun test_correct_email_correct_password_opens_login_activity_success() {
        onView((withId(R.id.et_username)))
            .perform(typeText(correctEmail))

        onView(withId(R.id.et_password))
            .perform(typeText(correctPassword))

        closeSoftKeyboard()
        Thread.sleep(1000)
        Intents.init()
        onView(withId(R.id.btn_firebase_login_signup))
            .perform(click())
        Thread.sleep(3000)

        Intents.intended(
            IntentMatchers.hasComponent(LoginActivity::class.java.name),
            (Intents.times(1))
        )

        Intents.release()

    }

    //Incorrect email password displays SnackBar error
    @Test
    fun test_repeated_email_returns_failure_toast() {
        onView((withId(R.id.et_username)))
            .perform(typeText(repeatEmail))

        onView(withId(R.id.et_password))
            .perform(typeText(correctPassword))

        closeSoftKeyboard()
        Thread.sleep(1000)

        onView(withId(R.id.btn_firebase_login_signup))
            .perform(click())
        Thread.sleep(3000)

//        // Is toast displayed and is the message correct?
//        onView(withText(R.string.signed_up_successfully)).inRoot(ToastMatcher())
//            .check(matches(not(isDisplayed())))

        //SnackBar error message display check
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Error Occurred")))
    }

    //Clicking on Sign In textview opens LoginActivity
    @Test
    fun sign_in_textview_click_open_login_activity() {
        Intents.init()
        onView(withId(R.id.tv_sign_in)).perform(click())
        Thread.sleep(3000)
        Intents.intended(
            IntentMatchers.hasComponent(LoginActivity::class.java.name),
            (Intents.times(1))
        )

        Intents.release()
    }
}