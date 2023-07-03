package otus.gpb.homework.viewandresources

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import otus.gpb.homework.viewandresources.databinding.DialogSigninBinding

class RegisterDialog(
    context: Context
): Dialog(context) {

    private lateinit var binding:DialogSigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogSigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val width = (context.resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = (context.resources.displayMetrics.heightPixels* 0.55).toInt()
        window?.setLayout(width, height)
        window?.setBackgroundDrawableResource(R.drawable.dialod_window_drawable)
    }

}