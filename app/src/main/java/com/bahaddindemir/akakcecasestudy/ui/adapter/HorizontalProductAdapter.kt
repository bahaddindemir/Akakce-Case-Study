package com.bahaddindemir.akakcecasestudy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.data.model.product.HorizontalProduct
import com.bahaddindemir.akakcecasestudy.databinding.ItemHorizontalProductBinding
import com.bahaddindemir.akakcecasestudy.ui.base.BaseAdapter
import com.bahaddindemir.akakcecasestudy.ui.viewholder.HorizontalProductViewHolder

class HorizontalProductAdapter(private val delegate: HorizontalProductViewHolder.Delegate) : BaseAdapter<HorizontalProduct>() {
  override fun getLayoutId(position: Int, obj: HorizontalProduct): Int {
    return R.layout.item_horizontal_product
  }

  override fun getViewHolder(binding: ViewBinding): RecyclerView.ViewHolder {
    return when (binding) {
      is ItemHorizontalProductBinding -> HorizontalProductViewHolder(binding, delegate)
      else -> throw IllegalArgumentException("Unknown ViewBinding")
    }
  }

  override val bindingInflater: (LayoutInflater, ViewGroup?, Int) -> ViewBinding
    get() =
      { inflater, parent, _ -> ItemHorizontalProductBinding.inflate(inflater, parent, false) }

  fun addHorizontalProductItemList(resource: List<HorizontalProduct>?) {
    setItems(resource!!)
  }
}