package com.padcmyanmar.padcx.androidarchitecturepatterns.ui_tests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcmyanmar.padcx.androidarchitecturepatterns.R
import com.padcmyanmar.padcx.androidarchitecturepatterns.activities.MainActivity
import com.padcmyanmar.padcx.androidarchitecturepatterns.views.viewholder.TourViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Phyoe Sandy Soe Tun
 * on 7/13/2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class HomeFragmentTest {

    private val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapHome_goToHomeScreen() {
        onView(withId(R.id.action_home)).perform(click())
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
    }

    @Test
    fun tapOnTours_navigateToDetailsScreen() {
        onView(withId(R.id.rvTour))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TourViewHolder>(0, click()))

        onView(withId(R.id.tvName))
            .check(matches(isDisplayed()))
    }


}