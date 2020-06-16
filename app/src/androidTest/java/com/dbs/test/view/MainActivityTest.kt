package com.dbs.test.view

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dbs.test.R
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @Test
    fun testIsActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.rlMain)).check(matches(isDisplayed()))
    }

    @Test
    fun testVisibilityToolbarAndCardView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))

        onView(withId(R.id.recycler_view)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun testTitleTextDisplayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.toolbar_title)).check(matches(withText("Articles")))
    }

    @Test
    fun testNavigationOnButtonClick() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.recycler_view)).perform(click())
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()))
    }

    @Test
    fun testBackPressToMainActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.recycler_view)).perform(click())
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.rlMain)).check(matches(isDisplayed()))
    }
}