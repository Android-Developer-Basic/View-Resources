package otus.gpb.homework.viewandresources.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import otus.gpb.homework.viewandresources.R
import otus.gpb.homework.viewandresources.databinding.CartSnippetBinding

class CartSnippet @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : LinearLayout (context, attrs, defStyleAttr, defStyleRes) {
    private val binding : CartSnippetBinding
    private var name = ""
    init {
        binding = CartSnippetBinding.inflate(LayoutInflater.from(context), this)
        // initPanel(attrs, defStyleAttr)
        initParams(attrs, defStyleAttr)
    }

    private fun initParams(attrs: AttributeSet?, defStyleAttr: Int) = with(binding) {
        context.withStyledAttributes(attrs, R.styleable.CartSnippet, defStyleAttr) {
            name = getString(R.styleable.CartSnippet_staffName)?: "Имя"
            textViewName.text = name

            val imageResId = getResourceId(R.styleable.CartSnippet_ImageRes, 0)
            if (imageResId != 0) {
                itemImage.setImageResource(imageResId)
            }

            val description = getString(R.styleable.CartSnippet_Description)?: "Описание"
            textViewDescription.text = description

            val price = getString(R.styleable.CartSnippet_Price)?: "Цена"
            textViewPrice.text = price


        }
    }


}