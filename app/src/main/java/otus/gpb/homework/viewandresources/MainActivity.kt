package otus.gpb.homework.viewandresources

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import android.widget.Switch
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

enum class Themes {
    SYSTEM, LIGHT, DARK
}

@Serializable
data class UserPreferencesStorage (var theme:Themes = Themes.SYSTEM)

object UserPreferences {
    private const val USER_PREFERENCES= "UserPrefs"
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings.dat")
    private var preferences = UserPreferencesStorage()
    init {
        load()
    }
    fun setTheme(newTheme: Themes) {
        preferences.theme=newTheme
    }
    fun getTheme() = preferences.theme

    fun store() {
        val json=Json.encodeToString(preferences)
        Context.dataStore.edit { settings ->
            settings[USER_PREFERENCES] = json
        }
    }

    private fun load() {
        preferences=Json.decodeFromString<UserPreferencesStorage>(json)
    }
}

open class ActivityHelper(contentLayoutId:Int=0): AppCompatActivity(contentLayoutId) {
    private val preferences=UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        loadTheme()
        super.onCreate(savedInstanceState)
    }

    private fun loadTheme() {
        when (preferences.getTheme()) {
            Themes.DARK -> setTheme(R.style.Theme_ThemeSwitcher_Dark)
            Themes.LIGHT -> setTheme(R.style.Theme_ThemeSwitcher_Light)
        }
    }

   open fun switchTheme(newTheme:Themes) {
        if (preferences.getTheme() == newTheme ) {
            return
        }
        preferences.setTheme(newTheme)
        preferences.store()
        recreate()
    }

   open fun currentTheme()=preferences.getTheme()
}

class MainActivity: ActivityHelper(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.xml_view_button).setOnClickListener {
            startActivity(Intent(this, MainXMLActivity::class.java))
        }

        findViewById<Spinner>(R.id.theme_selector).apply {
            ArrayAdapter.createFromResource(
                context,
                R.array.themes,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears.
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner.
                this.adapter = adapter
                this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                        // An item is selected. You can retrieve the selected item using
                        when (pos) {
                            1 -> switchTheme(Themes.LIGHT)
                            2 -> switchTheme(Themes.DARK)
                            else -> switchTheme(Themes.SYSTEM)
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        switchTheme(Themes.SYSTEM)
                    }
                }
                when (currentTheme()) {
                    Themes.LIGHT -> setSelection(1)
                    Themes.DARK -> setSelection(2)
                    else -> setSelection(0)
                }
            }
        }
    }
    override fun switchTheme(newTheme: Themes)=super.switchTheme(newTheme)
    override fun currentTheme()=super.currentTheme()
}


        /* suspend private fun saveTheme(isDarkTheme: Boolean) {
             dataStore.edit { settings ->
                 settings[this.PREF_IS_DARK_THEME] = isDarkTheme
             }
         }

         private fun loadTheme(): Boolean {
             val exampleCounterFlow: Flow<Int> = context.dataStore.data
                 .map { preferences ->
                     // No type safety.
                     preferences[EXAMPLE_COUNTER] ?: 0
                 }

         }*/

class MainXMLActivity : ActivityHelper() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_xml)
        findViewById<Button>(R.id.contacts_button).setOnClickListener {
            startActivity(Intent(this, ContactsActivity::class.java))
        }

        findViewById<Button>(R.id.cart_button).setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        findViewById<Button>(R.id.signin_button).setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setView(R.layout.dialog_signin)
                .show()
        }
    }
}