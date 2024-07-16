package com.example.eldersfirstapp

import com.example.eldersfirstapp.Repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

//inject -вай
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideMainRepository() = MainRepository(OkHttpClient())

    @Provides
    fun provideOkHttpClient(): OkHttpClient{
        return OkHttpClient()
    }

}

