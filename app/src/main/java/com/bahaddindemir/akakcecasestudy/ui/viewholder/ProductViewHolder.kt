package com.bahaddindemir.akakcecasestudy.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bahaddindemir.akakcecasestudy.data.model.product.Product
import com.bahaddindemir.akakcecasestudy.databinding.ItemProductBinding
import com.bahaddindemir.akakcecasestudy.ui.base.BaseAdapter

class ProductViewHolder(private val binding: ItemProductBinding, private val delegate: Delegate) :
  RecyclerView.ViewHolder(binding.root), BaseAdapter.Binder<Product> {
  interface Delegate {
    fun onItemClick(productItem: Product, view: View)
  }

  override fun bind(data: Product) {
    binding.apply {
      productItem = data
      executePendingBindings()
    }

    itemView.setOnClickListener { delegate.onItemClick(data, view = it) }
  }
}