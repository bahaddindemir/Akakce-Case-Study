package com.bahaddindemir.akakcecasestudy.di

import com.bahaddindemir.akakcecasestudy.data.services.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
                       .readTimeout(30, TimeUnit.SECONDS)
                       .writeTimeout(30, TimeUnit.SECONDS)
                       .connectTimeout(30, TimeUnit.SECONDS)
                       .build()
  }

  @Provides
  @Singleton
  fun provideApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
  }
}