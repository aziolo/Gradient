package pl.daftcode.gradient.matchers

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class DrawableMatcher(@DrawableRes private val resourceId: Int) : TypeSafeMatcher<View>() {

    override fun matchesSafely(target: View): Boolean {
        val imageView = target as? ImageView ?: return false
        if (resourceId < 0) return imageView.drawable == null
        val drawablesColor = ContextCompat.getColor(imageView.context, android.R.color.black)
        val expectedDrawable = ContextCompat.getDrawable(imageView.context, resourceId)?.colorIn(drawablesColor) ?: return false
        val imageViewDrawable = imageView.drawable.colorIn(drawablesColor)
        return imageViewDrawable.compareTo(expectedDrawable)
    }

    private fun Drawable.colorIn(@ColorInt color: Int) = apply {
        mutate()
        setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
    }

    override fun describeTo(description: Description) {
        description.appendText("contains drawable with id: $resourceId")
    }

    private fun Drawable.compareTo(other: Drawable) = toBitmap().sameAs(other.toBitmap())
}
