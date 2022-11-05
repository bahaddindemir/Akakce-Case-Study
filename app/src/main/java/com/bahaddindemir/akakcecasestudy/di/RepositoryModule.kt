package com.bahaddindemir.akakcecasestudy.di

import com.bahaddindemir.akakcecasestudy.data.repository.product.ProductRepository
import com.bahaddindemir.akakcecasestudy.data.repository.product.ProductRepositoryImpl
import com.bahaddindemir.akakcecasestudy.data.services.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

  @Provides
  @Singleton
  fun provideProductRepository(apiService: ApiService):
      ProductRepository = ProductRepositoryImpl(apiService)
}