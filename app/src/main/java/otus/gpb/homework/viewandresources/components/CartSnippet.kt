package otus.gpb.homework.viewandresources.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import otus.gpb.homework.viewandresources.databinding.CartSnippetBinding

class CartSnippet @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : LinearLayout (context, attrs, defStyleAttr, defStyleRes) {
    private val binding : CartSnippetBinding
    init {
        binding = CartSnippetBinding.inflate(LayoutInflater.from(context), this)
    }



}