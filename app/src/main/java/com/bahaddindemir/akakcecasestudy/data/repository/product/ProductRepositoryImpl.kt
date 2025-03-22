package com.bahaddindemir.akakcecasestudy.data.repository.product

import com.bahaddindemir.akakcecasestudy.data.model.Result
import com.bahaddindemir.akakcecasestudy.data.model.product.DetailScreenResult
import com.bahaddindemir.akakcecasestudy.data.model.product.MainResult
import com.bahaddindemir.akakcecasestudy.data.services.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService) :
  ProductRepository {
  override suspend fun getProductList(): Result<MainResult> {
    return withContext(Dispatchers.IO) {
      handleApi { apiService.getProductList() }
    }
  }

  override suspend fun getProductDetail(productCode: Int): Result<DetailScreenResult> {
    return withContext(Dispatchers.IO) {
      handleApi { apiService.getProductDetail(productCode) }
    }
  }

  override suspend fun getNextProductList(nextUrl: String): Result<MainResult> {
    return withContext(Dispatchers.IO) {
      handleApi { apiService.getNextProductList(nextUrl) }
    }
  }

  private suspend fun <T> handleApi(call: suspend () -> Response<T>): Result<T> {
    return try {
      val response = call()
      if (response.isSuccessful) {
        val body = response.body()
        if (body != null) {
          Result.Success(body)
        } else {
          Result.Error(response.code(), "Empty response body")
        }
      } else {
        Result.Error(response.code(), response.message())
      }
    } catch (e: Exception) {
      Result.Error(-1, e.localizedMessage ?: "An unknown error occurred")
    }
  }
}