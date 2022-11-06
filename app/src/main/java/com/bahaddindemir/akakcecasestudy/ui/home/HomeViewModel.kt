package com.bahaddindemir.akakcecasestudy.ui.home

import androidx.lifecycle.*
import com.bahaddindemir.akakcecasestudy.data.model.ApiResponse
import com.bahaddindemir.akakcecasestudy.data.model.product.MainResult
import com.bahaddindemir.akakcecasestudy.data.repository.product.ProductRepository
import com.bahaddindemir.akakcecasestudy.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val productRepository: ProductRepository) : BaseViewModel() {
  private inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
    return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
      emitSource(block())
    }
  }

  private var nextProductListPage: MutableLiveData<String> = MutableLiveData()

  val productLiveData: LiveData<ApiResponse<MainResult>> = launchOnViewModelScope {
    productRepository.getProductList()
  }
  val nextProductLiveData: LiveData<ApiResponse<MainResult>> = nextProductListPage.switchMap {
    launchOnViewModelScope { productRepository.getNextProductList(it) }
  }

  fun getNextResult(nextUrl: String) {
    nextProductListPage.postValue(nextUrl)
  }
}