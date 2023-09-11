package com.example.movieapi

import com.example.movieapi.BuildConfig.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): ApiService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build().create(ApiService::class.java)
    }
}