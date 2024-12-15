package otus.gpb.homework.viewandresources

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.contacts_button).setOnClickListener {
            openContacts()
        }

        findViewById<Button>(R.id.cart_button).setOnClickListener {
            openCart()
        }

        findViewById<Button>(R.id.signin_button).setOnClickListener {
            showSignInDialog()
        }

        // Set up click listener for the button
        findViewById<ImageButton>(R.id.btn_main_menu).setOnClickListener {
            showMainMenu()
        }

    }

    // Function to show an MDC3-styled main menu
    private fun showMainMenu() {
        // Items to display in the menu
        val menuItems = arrayOf("Contacts", "Cart", "Sign in", "Exit")

        // Create a MaterialAlertDialogBuilder
        MaterialAlertDialogBuilder(this)
            .setTitle("Main Menu")
            .setItems(menuItems) { _, which ->
                // Handle menu item click
                when (which) {
                    0 -> openContacts()
                    1 -> openCart()
                    2 -> showSignInDialog()
                    3 -> exitApp()
                }
            }
            .show()
    }

    private fun exitApp() {
        NotificationManagerCompat.from(this).cancelAll()
        finishAndRemoveTask()
    }

    private fun openContacts() {
        startActivity(Intent(this, ContactsActivity::class.java))
    }

    private fun openCart() {
        startActivity(Intent(this, CartActivity::class.java))
    }

    private fun showSignInDialog() {
        // Создаем диалог
        val dialog = MaterialAlertDialogBuilder(this)
            .setView(R.layout.dialog_signin)
            .create()

        // Показываем диалог
        dialog.show()

        // Получаем ссылки на кнопки из кастомного макета
        val loginButton = dialog.findViewById<MaterialButton>(R.id.login_button)
        val cancelButton = dialog.findViewById<MaterialButton>(R.id.cancel_button)

        // Обработчики нажатий
        loginButton?.setOnClickListener {
            val loginInput = dialog.findViewById<TextInputEditText>(R.id.login_input)?.text.toString()
            val passwordInput = dialog.findViewById<TextInputEditText>(R.id.password_input)?.text.toString()

            // Ваш код для входа
            if (loginInput.isNotEmpty() && passwordInput.isNotEmpty()) {
                Toast.makeText(this, "Login: $loginInput, Password: $passwordInput", Toast.LENGTH_SHORT).show()
                dialog.dismiss() // Закрыть диалог после успешного ввода
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        cancelButton?.setOnClickListener {
            dialog.dismiss() // Закрыть диалог при нажатии на "Отмена"
        }
    }
}