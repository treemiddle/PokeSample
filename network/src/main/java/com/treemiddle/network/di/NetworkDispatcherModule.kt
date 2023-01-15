package com.treemiddle.network.di

import com.treemiddle.network.Dispatcher
import com.treemiddle.network.NetworkDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object NetworkDispatcherModule {
    @Provides
    @Dispatcher(NetworkDispatchers.IO)
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}
