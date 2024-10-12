package otus.gpb.homework.viewandresources.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CartItem(
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val price: Int,
)
