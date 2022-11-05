package com.bahaddindemir.akakcecasestudy.ui.base

import androidx.lifecycle.ViewModel
import com.bahaddindemir.akakcecasestudy.util.SingleLiveEvent

open class BaseViewModel : ViewModel() {
  var dataLoadingEvent: SingleLiveEvent<Int> = SingleLiveEvent()
}