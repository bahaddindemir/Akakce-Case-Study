package com.bahaddindemir.akakcecasestudy.data.services

import com.bahaddindemir.akakcecasestudy.data.model.product.DetailScreenResult
import com.bahaddindemir.akakcecasestudy.data.model.product.MainResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
  @GET(PRODUCTS)
  fun getProductList(): Response<MainResult>

  @GET(DETAIL)
  fun getProductDetail(@Query("code") code: Int): Response<DetailScreenResult>

  @GET
  fun getNextProductList(@Url nextUrl: String): Response<MainResult>

  companion object {
    const val PRODUCTS = "59906f35-d5d5-40f7-8d44-53fd26eb3a05"
    const val DETAIL   = "1a1fb542-22d1-4919-914a-750114879775"
  }
}