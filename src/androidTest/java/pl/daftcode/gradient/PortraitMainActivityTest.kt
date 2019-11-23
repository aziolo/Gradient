package pl.daftcode.gradient

import android.content.pm.ActivityInfo
import org.junit.Before

class PortraitMainActivityTest : BaseMainActivityTest() {

    @Before
    fun setUp() {
        activityRule.scenario.onActivity {
            it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            Thread.sleep(500)
        }
    }
}
