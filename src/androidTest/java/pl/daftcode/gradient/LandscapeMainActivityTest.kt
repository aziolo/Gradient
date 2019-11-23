package pl.daftcode.gradient

import android.content.pm.ActivityInfo
import org.junit.Before

class LandscapeMainActivityTest : BaseMainActivityTest() {

    @Before
    fun setUp() {
        activityRule.scenario.onActivity {
            it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            Thread.sleep(500)
        }
    }
}
