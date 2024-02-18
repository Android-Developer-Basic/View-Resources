package otus.gpb.homework.viewandresources

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class ActivityHelper(contentLayoutId:Int=0): AppCompatActivity(contentLayoutId) {

    private val preferences=UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        preferences.load(this)
        loadTheme()
        super.onCreate(savedInstanceState)
    }

    private fun loadTheme() {
        when (preferences.getTheme()) {
            Themes.DARK -> setTheme(R.style.Theme_ThemeSwitcher_Dark)
            Themes.LIGHT -> setTheme(R.style.Theme_ThemeSwitcher_Light)
            else -> setTheme(R.style.Theme_ViewResources)
        }
    }

    open fun switchTheme(newTheme:Themes) {
        if (preferences.getTheme() == newTheme ) {
            return
        }
        preferences.setTheme(newTheme)
        preferences.store(this)
        recreate()
    }

    open fun currentMode()=preferences.getMode()

    open fun switchMode(newMode: Modes) {
        if (preferences.getMode() ==  newMode) {
            return
        }
        preferences.setMode(newMode)
        preferences.store(this)
    }


    open fun currentTheme()=preferences.getTheme()

    fun currentScreen() = preferences.getCurrentScreen()
    fun switchCurrentScreen(newScreen:Screens) {
        if (preferences.getCurrentScreen() == newScreen ) {
            return
        }
        preferences.setCurrentScreen(newScreen)
        preferences.store(this)
    }
}