package com.treemiddle.network.di

import com.treemiddle.network.NetworkConstants
import com.treemiddle.network.interceptor.PokeRequestInterceptor
import com.treemiddle.network.service.PokeService
import com.treemiddle.network.service.PokeServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(PokeRequestInterceptor())
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providePokeService(retrofit: Retrofit): PokeService =
        retrofit.create(PokeService::class.java)

    @Provides
    @Singleton
    fun providePokeServiceImpl(pokeService: PokeService): PokeServiceImpl =
        PokeServiceImpl(pokeService)
}
