package com.bahaddindemir.akakcecasestudy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.bahaddindemir.akakcecasestudy.data.model.Result
import com.bahaddindemir.akakcecasestudy.data.model.product.DetailScreenResult
import com.bahaddindemir.akakcecasestudy.data.repository.product.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {
  private inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> T): LiveData<T> {
    return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
      emit(block())
    }
  }

  private var productItem: MutableLiveData<Int> = MutableLiveData()
  val productDetailLiveData: LiveData<DetailScreenResult?> = productItem.switchMap { productItem ->
    launchOnViewModelScope {
      when (val response = productRepository.getProductDetail(productItem)) {
        is Result.Success -> {
          response.data
        }

        is Result.Error -> {
          null
        }
      }
    }
  }

  fun postProductDetailId(productItemId: Int) = productItem.postValue(productItemId)
}