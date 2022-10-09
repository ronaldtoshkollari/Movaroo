package com.ronalad.mavaroo.di

import com.ronalad.mavaroo.network.repository.IMBDbRepo
import com.ronalad.mavaroo.popular_movies.domain.use_cases.GetPopularMoviesUseCase
import com.ronalad.mavaroo.title_details.domain.use_cases.GetTitleDetailsUseCase
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

    @Provides
    @Singleton
    fun provideGetTitleDetailsUseCase(imbDbRepo: IMBDbRepo) : GetTitleDetailsUseCase {
        return GetTitleDetailsUseCase(imbDbRepo)
    }

}