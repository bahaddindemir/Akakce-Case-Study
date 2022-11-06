package com.bahaddindemir.akakcecasestudy.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bahaddindemir.akakcecasestudy.data.model.product.MainResult
import com.bahaddindemir.akakcecasestudy.ui.adapter.HorizontalProductAdapter
import com.bahaddindemir.akakcecasestudy.ui.adapter.ProductAdapter

@BindingAdapter("adapterProduct")
fun bindAdapterProduct(view: RecyclerView, resource: MainResult?) {
  if (resource != null) {
    val adapter = view.adapter as? ProductAdapter
    adapter?.addProductItemList(resource.result?.products)
  }
}

@BindingAdapter("adapterHorizontalProduct")
fun bindAdapterHorizontalProduct(view: ViewPager2, resource: MainResult?) {
  if (resource != null) {
    val adapter = view.adapter as? HorizontalProductAdapter
    adapter?.addHorizontalProductItemList(resource.result?.horizontalProducts)
  }
}