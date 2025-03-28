package com.bahaddindemir.akakcecasestudy.di

import com.bahaddindemir.akakcecasestudy.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
object RetrofitModule {

  @Provides
  @Singleton
  fun provideGson(): Gson {
    return GsonBuilder()
      .setLenient()
      .serializeNulls() // To allow sending null values
      .create()
  }

  @Provides
  @Singleton
  fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
                                                                                  .client(okHttpClient)
                                                                                  .addConverterFactory(GsonConverterFactory.create(gson))
                                                                                  .baseUrl(BuildConfig.API_BASE_URL)
                                                                                  .build()
}