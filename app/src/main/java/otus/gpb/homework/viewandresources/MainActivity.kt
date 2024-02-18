package otus.gpb.homework.viewandresources

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.ContextThemeWrapper
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

class MainActivity: ActivityHelper(R.layout.activity_main) {

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.xml_view_button).setOnClickListener {
            switchMode(Modes.XML)
            startActivity(Intent(this, MainXMLActivity::class.java))
        }
        findViewById<Button>(R.id.composer_view_button).setOnClickListener {
            switchMode(Modes.COMPOSER)
            startActivity(Intent(this, MainComposerActivity::class.java))
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

