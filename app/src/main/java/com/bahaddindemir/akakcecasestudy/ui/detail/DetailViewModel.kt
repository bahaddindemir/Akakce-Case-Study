package com.bahaddindemir.akakcecasestudy.ui.detail

import androidx.lifecycle.*
import com.bahaddindemir.akakcecasestudy.data.model.ApiResponse
import com.bahaddindemir.akakcecasestudy.data.model.product.DetailScreenResult
import com.bahaddindemir.akakcecasestudy.data.repository.product.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {
  private inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
    return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
      emitSource(block())
    }
  }

  private var productItem: MutableLiveData<Int> = MutableLiveData()
  val productDetailLiveData: LiveData<ApiResponse<DetailScreenResult>> = productItem.switchMap { productItem ->
    launchOnViewModelScope { this.productRepository.getProductDetail(productItem) }
  }

  fun postProductDetailId(productItemId: Int) = productItem.postValue(productItemId)
}