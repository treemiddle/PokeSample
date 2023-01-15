package com.treemiddle.network.di

import com.treemiddle.network.NetworkDataSource
import com.treemiddle.network.NetworkDataSourceImpl
import com.treemiddle.network.service.PokeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideNetworkDataSourceImpl(pokeService: PokeService): NetworkDataSource {
        return NetworkDataSourceImpl(pokeService)
    }
}
