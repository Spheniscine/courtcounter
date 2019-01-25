package com.github.spheniscine.udacityredone.courtcounter

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

fun assertDisplayed(resId: Int) {
    Espresso.onView(ViewMatchers.withId(resId)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
}

fun assertDisplayed(resId: Int, string: String) {
    assertDisplayed(resId)
    Espresso.onView(ViewMatchers.withId(resId)).check(ViewAssertions.matches(ViewMatchers.withText(string)))
}