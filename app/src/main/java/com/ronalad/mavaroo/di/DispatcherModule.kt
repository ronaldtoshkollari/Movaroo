//package com.ronalad.mavaroo.di
//
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import kotlinx.coroutines.CoroutineDispatcher
//import kotlinx.coroutines.Dispatchers
//import javax.inject.Qualifier
//
//@Module
//@InstallIn(::class)
//class DispatcherModule {
//
//    @DefaultDispatcher
//    @Provides
//    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
//
//    @IoDispatcher
//    @Provides
//    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
//
//    @MainDispatcher
//    @Provides
//    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
//}
//
//@Retention(AnnotationRetention.BINARY)
//@Qualifier
//annotation class DefaultDispatcher
//
//@Retention(AnnotationRetention.BINARY)
//@Qualifier
//annotation class IoDispatcher
//
//@Retention(AnnotationRetention.BINARY)
//@Qualifier
//annotation class MainDispatcher