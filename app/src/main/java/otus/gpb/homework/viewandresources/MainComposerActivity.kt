package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.FlowPreview

class MainComposerActivity : ActivityHelper() {

    private fun showContacts() {
    }

    private fun showCart() {
    }

    private fun showDialog() {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityButtons()
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

    @Composable
    @Preview
    fun ActivityButtons( ) {
        Column(
            Modifier.fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp)
            .background(Color.Yellow)
        ) {
            Button(
                onClick = { showContacts() }
            ) {
                Text(stringResource(R.string.button_open_contacts),Modifier.fillMaxWidth())
            }
            Button(onClick = { showCart() }) {
                Text(stringResource(R.string.button_open_cart))
            }
            Button(onClick = { showDialog() }) {
                Text(stringResource(R.string.button_open_signin))
            }
        }

    }
}



