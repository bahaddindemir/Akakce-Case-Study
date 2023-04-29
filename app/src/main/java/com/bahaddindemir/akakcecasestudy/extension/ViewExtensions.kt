package com.bahaddindemir.akakcecasestudy.extension

import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.Group
import com.google.android.material.snackbar.Snackbar

fun View.show() {
  if (visibility == View.VISIBLE) return

  visibility = View.VISIBLE
  if (this is Group) {
    this.requestLayout()
  }
}

fun View.showSnackBar(message: String, retryActionName: String? = null, action: (() -> Unit)? = null) {
  val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)

  val view: View = snackBar.view
  val params = view.layoutParams as FrameLayout.LayoutParams
  params.gravity = Gravity.TOP
  view.layoutParams = params

  action?.let {
    snackBar.setAction(retryActionName) {
      it()
    }
  }

  snackBar.show()
}