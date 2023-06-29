package otus.gpb.homework.domain.use_cases

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException
import java.net.URL

class GetImageFromUrlUseCase(private val str: String) {
    fun getBitmap(): Bitmap?{
        return try {
            val url = URL(str)
            BitmapFactory.decodeStream(url.openStream())
        }catch (e: IOException){
            null
        }
    }
}