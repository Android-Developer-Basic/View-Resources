package otus.gpb.homework.di

import dagger.Component
import otus.gpb.homework.viewandresources.view_model.CartViewModel


@Component(modules = [DataModule::class])
interface AppComponent {
    fun initCartViewModel(cartViewModel: CartViewModel)
}