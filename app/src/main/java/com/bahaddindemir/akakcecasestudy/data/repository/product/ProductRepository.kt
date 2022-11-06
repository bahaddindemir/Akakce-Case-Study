package com.bahaddindemir.akakcecasestudy.data.repository.product

import androidx.lifecycle.LiveData
import com.bahaddindemir.akakcecasestudy.data.model.ApiResponse
import com.bahaddindemir.akakcecasestudy.data.model.product.DetailScreenResult
import com.bahaddindemir.akakcecasestudy.data.model.product.MainResult

interface ProductRepository {
  suspend fun getProductList() : LiveData<ApiResponse<MainResult>>

  suspend fun getProductDetail(productCode: Int) : LiveData<ApiResponse<DetailScreenResult>>
}