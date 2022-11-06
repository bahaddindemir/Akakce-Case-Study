package com.bahaddindemir.akakcecasestudy.ui.adapter

import android.annotation.SuppressLint
import android.view.View
import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.data.model.product.Product
import com.bahaddindemir.akakcecasestudy.ui.base.BaseViewHolder
import com.bahaddindemir.akakcecasestudy.ui.base.BaseAdapter
import com.bahaddindemir.akakcecasestudy.ui.viewholder.ProductViewHolder
import com.bahaddindemir.akakcecasestudy.util.SectionRow

class ProductAdapter(private val delegate: ProductViewHolder.Delegate) : BaseAdapter() {
  init {
    addSection(ArrayList<Product>())
  }

  @SuppressLint("NotifyDataSetChanged")
  fun addProductItemList(resource: List<Product>?) {
    resource?.let {
      sections()[0].addAll(it)
      notifyDataSetChanged()
    }
  }

  override fun layout(sectionRow: SectionRow): Int = R.layout.item_product

  override fun viewHolder(layout: Int, view: View): BaseViewHolder = ProductViewHolder(view, delegate)
}