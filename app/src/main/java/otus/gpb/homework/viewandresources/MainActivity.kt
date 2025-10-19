package otus.gpb.homework.viewandresources

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    private val dialog by lazy { createMaterialDialog() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.contacts_button).setOnClickListener {
            startActivity(Intent(this, ContactsActivity::class.java))
        }

        findViewById<Button>(R.id.cart_button).setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        findViewById<Button>(R.id.signin_button).setOnClickListener {
            dialog.show()
        }
    }

    /**
     * Создаёт и настраивает MaterialAlertDialog для входа пользователя.
     *
     * Диалог включает в себя поля для ввода логина и пароля, а также кнопки подтверждения и отмены.
     * При нажатии на кнопки логирует действия пользователя и закрывает диалог.
     *
     * @return Настроенный экземпляр [AlertDialog].
     */
    private fun createMaterialDialog(): AlertDialog = MaterialAlertDialogBuilder(this)
        .setTitle(R.string.dialog_title)
        .setView(R.layout.dialog_signin)
        .setPositiveButton(R.string.dialog_login_button) { dialog, which ->
            Log.d("debug_granted", "chooseImageDialog onPositiveButtonClickListener.")
            dialog.dismiss()
        }
        .setNegativeButton(R.string.dialog_canceled_button) { dialog, which ->
            Log.d("debug_granted", "chooseImageDialog onNegativeButtonClickListener.")
            dialog.dismiss()
        }
        .setOnDismissListener {
            Log.d("debug_granted", "chooseImageDialog onDismissListener.")
        }
        .create()
}