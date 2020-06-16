package com.dbs.test.view

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dbs.test.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ArticleDetailsActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(ArticleDetailsActivity::class.java)

    @Test
    fun isActivityInView() {
        onView(withId(R.id.clDetailsActivity)).check(matches(isDisplayed()))
    }

    @Test
    fun testVisibilityLayout() {
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()))
    }
}