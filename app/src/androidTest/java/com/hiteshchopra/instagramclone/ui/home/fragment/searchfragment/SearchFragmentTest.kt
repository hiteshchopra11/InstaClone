package com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.annotation.UiThreadTest
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.ui.home.HomeActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.junit.Rule
import org.junit.Test

class SearchFragmentTest {

    //    //Note: This is new
//    @Rule
//    var uiThreadTestRule = UiThreadTestRule()
//
    //ActivityTestRule is deprecated
    @get:Rule
    var activityScenarioRule = activityScenarioRule<HomeActivity>()
//
//    // An Idling Resource that waits for Data Binding to have no pending bindings
//    private val dataBindingIdlingResource = DataBindingIdlingResource()
//
//    /**
//     * Idling resources tell Espresso that the app is idle or busy. This is needed when operations
//     * are not scheduled in the main Looper (for example when executed on a different thread).
//     */
//    @Before
//    fun registerIdlingResource() {
//        IdlingRegistry.getInstance()
//            .register(EspressoIdlingResource.countingIdlingResource)
//        IdlingRegistry.getInstance()
//            .register(dataBindingIdlingResource)
//    }
//
//    /**
//     * Unregister your Idling Resource so it can be garbage collected and does not leak any memory.
//     */
//    @After
//    fun unregisterIdlingResource() {
//        IdlingRegistry.getInstance()
//            .unregister(EspressoIdlingResource.countingIdlingResource)
//        IdlingRegistry.getInstance()
//            .unregister(dataBindingIdlingResource)
//    }

    @FlowPreview
    @ExperimentalCoroutinesApi
    @Test
    fun valid_query_display_images() {
        val query = "wallpaper"
        // Create a TestNavHostController
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        navController.setGraph(R.navigation.nav_graph)

        // Create a graphical FragmentScenario for the TitleScreen
        val titleScenario = launchFragmentInContainer<SearchFragment>()

        // Set the NavController property on the fragment
        titleScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        onView(withId(R.id.search_view)).perform(typeText(query))
        onView(withId(R.id.tv_search_placeholder)).check(doesNotExist())

    }
}

@Test
fun invalid_query_display_empty_textview() {
    val query = "wfkbfewhkbhddbc"
    onView(withId(R.id.search_view)).perform(typeText(query))
    onView(withId(R.id.tv_search_placeholder)).check(matches(isDisplayed()))
}

@Test
fun short_query_display_empty_textView() {
    val query = "ca"
    onView(withId(R.id.search_view)).perform(typeText(query))
    onView(withId(R.id.tv_search_placeholder)).check(matches(isDisplayed()))
}


