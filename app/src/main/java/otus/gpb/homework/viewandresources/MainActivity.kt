package otus.gpb.homework.viewandresources

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Filter
import androidx.annotation.ArrayRes
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
    fun getMode() = preferences.mode

    fun setCurrentScreen(currentScreen: Screens) {
        preferences.screen=currentScreen
    }

    fun getCurrentScreen() = preferences.screen

    fun store(context: Context) {
        val json=Json.encodeToString(preferences)
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
        }
    }
}

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

class FArrayAdapter<T>(
    context: Context?, textViewResourceId: Int,
    objects: List<T>
) : ArrayAdapter<T>(context!!, textViewResourceId, objects) {
    private var filter:Filter = NoFilter()
    var items: List<T> = objects
    override fun getFilter(): Filter {
        return filter
    }
    fun setFiltering(on: Boolean) {
        filter= if (on) super.getFilter() else NoFilter()
    }

    private inner class NoFilter : Filter() {
        override fun performFiltering(arg0: CharSequence): FilterResults {
            val result = FilterResults()
            result.values = items
            result.count = items.size
            return result
        }

        override fun publishResults(arg0: CharSequence, arg1: FilterResults) {
            notifyDataSetChanged()
        }
    }

    companion object {
        fun createFromResource(
            context: Context,
            @ArrayRes textArrayResId: Int, @LayoutRes textViewResId: Int
        ): FArrayAdapter<CharSequence?> {
            val strings = context.resources.getTextArray(textArrayResId)
            return FArrayAdapter(context, textViewResId, listOf(*strings))
        }
    }
}

class MainActivity: ActivityHelper(R.layout.activity_main) {

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.xml_view_button).setOnClickListener {
            switchMode(Modes.XML)
            startActivity(Intent(this, MainXMLActivity::class.java))
        }

        when (currentMode()) {
            Modes.XML -> startActivity(Intent(this, MainXMLActivity::class.java))
            else -> {}
        }

        findViewById<AutoCompleteTextView>(R.id.theme_selector).apply {
            FArrayAdapter.createFromResource(
                context,
                R.array.themes,
                R.layout.drop_down_item
            ).also { adapter ->
                adapter.setFiltering(false)
                this.setAdapter(adapter)
                this.onItemClickListener = AdapterView.OnItemClickListener { parent, view, pos, id ->
                    when (pos) {
                        1 -> switchTheme(Themes.LIGHT)
                        2 -> switchTheme(Themes.DARK)
                        else -> switchTheme(Themes.SYSTEM)
                    }
                }
               when (currentTheme()) {
                    Themes.LIGHT -> setText(resources.getStringArray(R.array.themes).get(1))
                    Themes.DARK -> setText(resources.getStringArray(R.array.themes).get(2))
                    else -> setText(resources.getStringArray(R.array.themes).get(0))
                }
            }
        }
    }
    override fun switchTheme(newTheme: Themes)=super.switchTheme(newTheme)
    override fun currentTheme()=super.currentTheme()

    override fun currentMode()=super.currentMode()

    override fun switchMode(newMode: Modes)=super.switchMode(newMode)

    override fun onRestart() {
        super.onRestart()
        switchMode(Modes.NONE)
    }
}


class MainXMLActivity : ActivityHelper() {

    private fun showContacts() {
        switchCurrentScreen(Screens.CONTACTS)
        startActivity(Intent(this, ContactsActivity::class.java))
    }

    private fun showCart() {
        switchCurrentScreen(Screens.CART)
        startActivity(Intent(this, CartActivity::class.java))
    }

    private fun showDialog() {
        switchCurrentScreen(Screens.DIALOG)
        MaterialAlertDialogBuilder(this)
            .setView(R.layout.dialog_signin)
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_xml)
        setSupportActionBar(findViewById(R.id.toolbar))

        val actionBar = supportActionBar
        requireNotNull(actionBar==null)
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        when (currentScreen()) {
            Screens.CONTACTS -> showContacts()
            Screens.CART -> showCart()
            Screens.DIALOG -> showDialog()
            else -> {}
        }
        findViewById<Button>(R.id.contacts_button).setOnClickListener {
            showContacts()
        }

        findViewById<Button>(R.id.cart_button).setOnClickListener {
            showCart()
        }

        findViewById<Button>(R.id.signin_button).setOnClickListener {
            showDialog()
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRestart() {
        super.onRestart()
        switchCurrentScreen(Screens.NONE)
    }
}