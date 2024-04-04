package otus.gpb.homework.viewandresources

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

enum class Themes {
    SYSTEM, LIGHT, DARK
}

enum class Screens {
    NONE, CONTACTS, CART, DIALOG
}

enum class Modes {
    NONE, XML, COMPOSER
}

@Serializable
data class UserPreferencesStorage (
    var theme:Themes = Themes.SYSTEM,
    var screen:Screens=Screens.NONE,
    var mode:Modes=Modes.NONE
)

object UserPreferences {

    private val tag = "UserPreferences"
    private val preferencesTag= stringPreferencesKey("JSON_user_prefs")
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings.dat")
    private var preferences = UserPreferencesStorage()
    /*init {
        load()
    }*/
    fun setTheme(newTheme: Themes) {
        preferences.theme=newTheme
    }
    fun getTheme() = preferences.theme

    fun setMode(newMode: Modes) {
        preferences.mode=newMode
    }
    fun getMode() = Modes.XML

    fun setCurrentScreen(currentScreen: Screens) {
        preferences.screen=currentScreen
    }

    fun getCurrentScreen() = preferences.screen

    fun store(context: Context) {
        val json= Json.encodeToString(preferences)
        runBlocking {
            launch {
                context.dataStore.edit { settings ->
                    settings[preferencesTag] = json
                }
            }
        }
    }

    fun load(context: Context) {
        //val context: Context = MainApplicationInstance().getApplicationInstance()
        runBlocking {
            val json: Flow<String> = context.dataStore.data
                .map { settings ->
                    // No type safety.
                    settings[preferencesTag] ?: ""
                }
            json.firstOrNull().also {
                try {
                    if (it!=null) {
                        preferences = Json.decodeFromString<UserPreferencesStorage>(it)
                    }
                } catch (e: Exception) {
                    Log.d(tag, e.message.toString())
                }
            }
            preferences.mode=Modes.XML
        }
    }
}