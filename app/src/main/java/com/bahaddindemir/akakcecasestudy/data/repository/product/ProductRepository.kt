package com.bahaddindemir.akakcecasestudy.data.repository.product

import com.bahaddindemir.akakcecasestudy.data.model.Result
import com.bahaddindemir.akakcecasestudy.data.model.product.DetailScreenResult
import com.bahaddindemir.akakcecasestudy.data.model.product.MainResult

interface ProductRepository {
  suspend fun getProductList() : Result<MainResult>

  suspend fun getProductDetail(productCode: Int) : Result<DetailScreenResult>

  suspend fun getNextProductList(nextUrl: String) : Result<MainResult>
}