package otus.gpb.homework.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import otus.gpb.homework.data.CartRepositoryImpl
import otus.gpb.homework.domain.repository.CartRepository

@Module
class DataModule {
    @Provides
    fun provideCartRepository():CartRepository = CartRepositoryImpl
}