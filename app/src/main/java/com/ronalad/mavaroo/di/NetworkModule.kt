package com.ronalad.mavaroo.di

import com.ronalad.mavaroo.data.remote.IMBDbApi
import com.ronalad.mavaroo.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideIMDbApi(): IMBDbApi {
        return Retrofit.Builder()
            .baseUrl(Constants.IMDB_BASE_URLS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IMBDbApi::class.java)
    }

}