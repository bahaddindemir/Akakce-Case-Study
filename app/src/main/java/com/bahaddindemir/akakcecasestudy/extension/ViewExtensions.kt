package com.bahaddindemir.akakcecasestudy.extension

import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.Group
import androidx.databinding.BindingAdapter
import com.google.android.material.snackbar.Snackbar

fun View.show() {
  if (visibility == View.VISIBLE) return

  visibility = View.VISIBLE
  if (this is Group) {
    this.requestLayout()
  }
}

fun View.hide() {
  if (visibility == View.GONE) return

  visibility = View.GONE
  if (this is Group) {
    this.requestLayout()
  }
}

fun View.invisible() {
  if (visibility == View.INVISIBLE) return

  visibility = View.INVISIBLE
  if (this is Group) {
    this.requestLayout()
  }
}

fun View.enable() {
  isEnabled = true
  alpha = 1f
}

fun View.disable() {
  isEnabled = false
  alpha = 0.5f
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