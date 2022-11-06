package com.bahaddindemir.akakcecasestudy.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bahaddindemir.akakcecasestudy.data.model.product.MainResult
import com.bahaddindemir.akakcecasestudy.ui.adapter.ProductAdapter

@BindingAdapter("adapterProduct")
fun bindAdapterProduct(view: RecyclerView, resource: MainResult?) {
  if (resource != null) {
    val adapter = view.adapter as? ProductAdapter
    adapter?.addProductItemList(resource.result?.products)
  }
}