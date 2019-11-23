package pl.daftcode.gradient.matchers

import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.annotation.ColorInt
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class BackgroundColorMatcher(@ColorInt private val color: Int) : TypeSafeMatcher<View>() {

    override fun matchesSafely(target: View): Boolean {
        val colorDrawable = target.background as? ColorDrawable ?: return false
        return colorDrawable.color == color
    }

    override fun describeTo(description: Description) {
        description.appendText("has background color: $color")
    }
}
