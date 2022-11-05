package com.bahaddindemir.akakcecasestudy.ui.viewholder

import android.view.View
import com.bahaddindemir.akakcecasestudy.data.model.product.Product
import com.bahaddindemir.akakcecasestudy.ui.base.BaseViewHolder
import com.bahaddindemir.akakcecasestudy.util.bindings

class ProductViewHolder (view: View, private val delegate: Delegate) : BaseViewHolder(view) {
  interface Delegate {
    fun onItemClick(productItem: Product, view: View)
  }

  private lateinit var productItem: Product
  //private val binding by bindings<ItemCoinBinding>(view)

  override fun bindData(data: Any) {
    if (data is Product) {
      productItem = data

      //binding.apply {
      //  productItem = data
      //  executePendingBindings()
      //}
    }
  }

  override fun onClick(view: View?) {
    view?.let {
      delegate.onItemClick(productItem, view)
    }
  }

  override fun onLongClick(v: View?): Boolean = false
}