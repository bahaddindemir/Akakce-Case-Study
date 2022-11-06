package com.bahaddindemir.akakcecasestudy.ui.adapter

import android.annotation.SuppressLint
import android.view.View
import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.data.model.product.HorizontalProduct
import com.bahaddindemir.akakcecasestudy.ui.base.BaseAdapter
import com.bahaddindemir.akakcecasestudy.ui.base.BaseViewHolder
import com.bahaddindemir.akakcecasestudy.ui.viewholder.HorizontalProductViewHolder
import com.bahaddindemir.akakcecasestudy.util.SectionRow

class HorizontalProductAdapter(private val delegate: HorizontalProductViewHolder.Delegate) : BaseAdapter() {
  init {
    addSection(ArrayList<HorizontalProduct>())
  }

  @SuppressLint("NotifyDataSetChanged")
  fun addHorizontalProductItemList(resource: List<HorizontalProduct>?) {
    resource?.let {
      sections()[0].addAll(it)
      notifyDataSetChanged()
    }
  }

  override fun layout(sectionRow: SectionRow): Int = R.layout.item_horizontal_product

  override fun viewHolder(layout: Int, view: View): BaseViewHolder = HorizontalProductViewHolder(view, delegate)
}