package com.bahaddindemir.akakcecasestudy.ui.viewholder

import android.view.View
import com.bahaddindemir.akakcecasestudy.data.model.product.HorizontalProduct
import com.bahaddindemir.akakcecasestudy.databinding.ItemHorizontalProductBinding
import com.bahaddindemir.akakcecasestudy.ui.base.BaseViewHolder
import com.bahaddindemir.akakcecasestudy.util.bindings

class HorizontalProductViewHolder(view: View, private val delegate: Delegate) : BaseViewHolder(view) {
  interface Delegate {
    fun onItemClick(horizontalProduct: HorizontalProduct, view: View)
  }

  private lateinit var horizontalProductItem: HorizontalProduct
  private val binding by bindings<ItemHorizontalProductBinding>(view)

  override fun bindData(data: Any) {
    if (data is HorizontalProduct) {
      horizontalProductItem = data

      binding.apply {
        productItem = data
        executePendingBindings()
      }
    }
  }

  override fun onClick(view: View?) {
    view?.let {
      delegate.onItemClick(horizontalProductItem, view)
    }
  }

  override fun onLongClick(v: View?): Boolean = false
}