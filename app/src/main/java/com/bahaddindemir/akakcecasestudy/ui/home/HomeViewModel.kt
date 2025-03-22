package com.bahaddindemir.akakcecasestudy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.bahaddindemir.akakcecasestudy.data.model.Result
import com.bahaddindemir.akakcecasestudy.data.model.product.MainResult
import com.bahaddindemir.akakcecasestudy.data.repository.product.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {
  private inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> T): LiveData<T> {
    return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
      emit(block())
    }
  }

  private var nextProductListPage: MutableLiveData<String> = MutableLiveData()

  val productLiveData: LiveData<MainResult?> = launchOnViewModelScope {
    when (val response = productRepository.getProductList()) {
      is Result.Success -> {
        response.data
      }

      is Result.Error -> {
        null
      }
    }
  }

  val nextProductLiveData: LiveData<MainResult?> = nextProductListPage.switchMap {
    launchOnViewModelScope {
      when (val response = productRepository.getNextProductList(it)) {
        is Result.Success -> {
          response.data
        }

        is Result.Error -> {
          null
        }
      }
    }
  }

  fun getNextResult(nextUrl: String) {
    nextProductListPage.postValue(nextUrl)
  }
}