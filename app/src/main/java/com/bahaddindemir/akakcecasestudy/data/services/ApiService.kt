package com.bahaddindemir.akakcecasestudy.data.services

import androidx.lifecycle.LiveData
import com.bahaddindemir.akakcecasestudy.data.model.ApiResponse
import com.bahaddindemir.akakcecasestudy.data.model.product.DetailScreenResult
import com.bahaddindemir.akakcecasestudy.data.model.product.MainResult
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
  @GET(PRODUCTS)
  @Headers("Accept: application/json")
  fun getProductList(): LiveData<ApiResponse<MainResult>>

  @GET(DETAIL)
  @Headers("Accept: application/json")
  fun getProductDetail(@Query("code") code: Int): LiveData<ApiResponse<DetailScreenResult>>

  @GET
  @Headers("Accept: application/json")
  fun getNextProductList(@Url nextUrl: String): LiveData<ApiResponse<MainResult>>

  companion object {
    const val PRODUCTS = "59906f35-d5d5-40f7-8d44-53fd26eb3a05"
    const val DETAIL   = "1a1fb542-22d1-4919-914a-750114879775"
  }
}