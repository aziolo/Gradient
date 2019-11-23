package pl.daftcode.gradient.matchers

import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import org.hamcrest.Matcher

fun withDrawable(@DrawableRes resourceId: Int): Matcher<View> = DrawableMatcher(resourceId)

fun withBackgroundColor(@ColorInt color: Int): Matcher<View> = BackgroundColorMatcher(color)
