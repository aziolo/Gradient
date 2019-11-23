package pl.daftcode.gradient

import android.graphics.Color
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withParentIndex
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.animation.ArgbEvaluatorCompat
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pl.daftcode.gradient.matchers.withBackgroundColor
import pl.daftcode.gradient.matchers.withDrawable

@RunWith(AndroidJUnit4::class)
abstract class BaseMainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    private val startColorHex = "#0ad560"
    private val endColorHex = "#12f6ff"

    @Test
    fun testUpAndDownButtonsShown() {
        onView(withDrawable(R.drawable.ic_arrow_down)).check(matches(isDisplayed()))
        onView(withDrawable(R.drawable.ic_arrow_up)).check(matches(isDisplayed()))
    }

    @Test
    fun testInitialState() {
        val firstColorHex = evaluateColorHex(1f / 7)
        assertViewWithHexAndParentIndex(startColorHex, 0)
        assertViewWithHexAndParentIndex(firstColorHex, 1)
        assertViewWithHexAndParentIndex(endColorHex, 7)
    }

    @Test
    fun testDownInteraction() {
        val zeroColorHex = evaluateColorHex(1f / 7)
        val fifthAndSeventhColorHex = evaluateColorHex((1f / 7) * 6)
        onView(withDrawable(R.drawable.ic_arrow_down)).perform(click())
        assertViewWithHexAndParentIndex(zeroColorHex, 0)
        assertViewWithHexAndParentIndex(fifthAndSeventhColorHex, 5)
        assertViewWithHexAndParentIndex(fifthAndSeventhColorHex, 7)
        assertViewWithHexAndParentIndex(endColorHex, 6)
    }

    @Test
    fun testUpInteraction() {
        val zeroAndSecondColorHex = evaluateColorHex(1f / 7)
        val seventhColorHex = evaluateColorHex((1f / 7) * 6)
        onView(withDrawable(R.drawable.ic_arrow_up)).perform(click())
        assertViewWithHexAndParentIndex(zeroAndSecondColorHex, 0)
        assertViewWithHexAndParentIndex(zeroAndSecondColorHex, 2)
        assertViewWithHexAndParentIndex(startColorHex, 1)
        assertViewWithHexAndParentIndex(seventhColorHex, 7)
    }

    private fun assertViewWithHexAndParentIndex(colorHex: String, parentIndex: Int) = onView(
        allOf(withParentIndex(parentIndex), withText(colorHex), withBackgroundColor(Color.parseColor(colorHex)))
    ).check(matches(isDisplayed()))

    private fun evaluateColorHex(fraction: Float) = ArgbEvaluatorCompat
            .getInstance()
            .evaluate(fraction, Color.parseColor(startColorHex), Color.parseColor(endColorHex))
            .let(::toHexString)
}
