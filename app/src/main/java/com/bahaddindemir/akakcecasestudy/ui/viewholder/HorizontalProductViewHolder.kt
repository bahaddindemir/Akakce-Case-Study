package com.bahaddindemir.akakcecasestudy.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bahaddindemir.akakcecasestudy.data.model.product.HorizontalProduct
import com.bahaddindemir.akakcecasestudy.databinding.ItemHorizontalProductBinding
import com.bahaddindemir.akakcecasestudy.ui.base.BaseAdapter

class HorizontalProductViewHolder(private val binding: ItemHorizontalProductBinding, private val delegate: Delegate) :
  RecyclerView.ViewHolder(binding.root), BaseAdapter.Binder<HorizontalProduct> {
  interface Delegate {
    fun onItemClick(horizontalProduct: HorizontalProduct, view: View)
  }

  override fun bind(data: HorizontalProduct) {
    binding.apply {
      productItem = data
      executePendingBindings()
    }

    itemView.setOnClickListener { delegate.onItemClick(data, view = it) }
  }
}