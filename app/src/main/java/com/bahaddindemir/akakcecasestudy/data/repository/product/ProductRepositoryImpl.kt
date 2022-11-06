package com.bahaddindemir.akakcecasestudy.data.repository.product

import androidx.lifecycle.LiveData
import com.bahaddindemir.akakcecasestudy.data.model.ApiResponse
import com.bahaddindemir.akakcecasestudy.data.model.product.DetailScreenResult
import com.bahaddindemir.akakcecasestudy.data.model.product.MainResult
import com.bahaddindemir.akakcecasestudy.data.services.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService) :
  ProductRepository {
  override suspend fun getProductList(): LiveData<ApiResponse<MainResult>> {
    return withContext(Dispatchers.IO) {
      return@withContext apiService.getProductList()
    }
  }

  override suspend fun getProductDetail(productCode: Int): LiveData<ApiResponse<DetailScreenResult>> {
    return withContext(Dispatchers.IO) {
      return@withContext apiService.getProductDetail(productCode)
    }
  }

  override suspend fun getNextProductList(nextUrl: String): LiveData<ApiResponse<MainResult>> {
    return withContext(Dispatchers.IO) {
      return@withContext apiService.getNextProductList(nextUrl)
    }
  }
}