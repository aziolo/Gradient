package pl.daftcode.gradient

import androidx.annotation.ColorInt

fun toHexString(@ColorInt color: Int): String = "#${Integer.toHexString(color).drop(2)}"
