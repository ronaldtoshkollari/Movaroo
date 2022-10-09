package com.ronalad.mavaroo.di

import com.ronalad.mavaroo.network.IMBDbApi
import com.ronalad.mavaroo.network.repository.IMBDbRepoImpl
import com.ronalad.mavaroo.network.repository.IMBDbRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {


    @Provides
    @Singleton
    fun provideIMDbRepositories(imbDbApi: IMBDbApi) : IMBDbRepo {
        return IMBDbRepoImpl(imbDbApi)
    }

}