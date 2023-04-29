package com.bahaddindemir.akakcecasestudy.extension

import androidx.fragment.app.Fragment

fun Fragment.showError(message: String, retryActionName: String? = null, action: (() -> Unit)? = null) =
  requireView().showSnackBar(message, retryActionName, action)