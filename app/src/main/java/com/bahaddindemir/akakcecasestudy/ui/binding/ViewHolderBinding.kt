package com.bahaddindemir.akakcecasestudy.ui.binding

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.di.GlideApp

@BindingAdapter("bindingProductImageUrl")
fun bindingProductImageUrl(imageView: ImageView, path: String?) {
  path?.let {
    GlideApp.with(imageView.context)
            .load(it)
            .error(ContextCompat.getDrawable(imageView.context, R.drawable.ic_launcher_foreground))
            .into(imageView)
  }
}