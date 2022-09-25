package com.ronalad.mavaroo.di

import com.ronalad.mavaroo.domain.repository.IMBDbRepo
import com.ronalad.mavaroo.domain.use_cases.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(imbDbRepo: IMBDbRepo) : GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(imbDbRepo)
    }

}