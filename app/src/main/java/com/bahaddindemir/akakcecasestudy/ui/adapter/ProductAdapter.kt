package com.bahaddindemir.akakcecasestudy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.data.model.product.Product
import com.bahaddindemir.akakcecasestudy.databinding.ItemProductBinding
import com.bahaddindemir.akakcecasestudy.ui.base.BaseAdapter
import com.bahaddindemir.akakcecasestudy.ui.viewholder.ProductViewHolder

class ProductAdapter(private val delegate: ProductViewHolder.Delegate) : BaseAdapter<Product>() {
  override fun getLayoutId(position: Int, obj: Product): Int {
    return R.layout.item_product
  }

  override fun getViewHolder(binding: ViewBinding): RecyclerView.ViewHolder {
    return when (binding) {
      is ItemProductBinding -> ProductViewHolder(binding, delegate)
      else -> throw IllegalArgumentException("Unknown ViewBinding")
    }
  }

  override val bindingInflater: (LayoutInflater, ViewGroup?, Int) -> ViewBinding
    get() =
      { inflater, parent, _ -> ItemProductBinding.inflate(inflater, parent, false) }

  fun addProductItemList(resource: List<Product>?) {
    setItems(resource!!)
  }
}