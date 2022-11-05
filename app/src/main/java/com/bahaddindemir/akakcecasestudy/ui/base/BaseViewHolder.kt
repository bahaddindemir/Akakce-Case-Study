package com.bahaddindemir.akakcecasestudy.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/** BaseViewHolder is an abstract class for structuring the base view holder class. */
@Suppress("LeakingThis")
abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {
  init {
    view.setOnClickListener(this)
    view.setOnLongClickListener(this)
  }

  /** binds data to the view holder class. */
  @Throws(Exception::class)
  abstract fun bindData(data: Any)
}