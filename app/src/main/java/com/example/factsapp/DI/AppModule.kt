package com.example.factsapp.DI

import com.example.factsapp.data.Repository.RepositoryImpl
import com.example.factsapp.data.remote.FactApi
import com.example.factsapp.domain.Repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFactApi(): FactApi {
        val retrofit =Retrofit.Builder()
            .baseUrl(FactApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(FactApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFactRepository(api:FactApi):Repository{
        return RepositoryImpl(api)
    }
}