package com.bahaddindemir.akakcecasestudy.ui.base

/*import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<VB : ViewDataBinding, T : ListAdapterItem>(
  diffCallback: DiffUtil.ItemCallback<T> = ListAdapterItemDiffCallback()
) : ListAdapter<T, BaseViewHolder<VB>>(diffCallback) {

  @get:LayoutRes
  protected abstract val layoutRes: Int

  protected abstract fun bind(binding: VB, item: T)

  /** returns [RecyclerView.ViewHolder] by layouts. */
  protected abstract fun viewHolder(@LayoutRes layout: Int, view: View): BaseViewHolder

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
    val view = inflateView(parent, viewType)
    return viewHolder(viewType, view)

    /*val binding = DataBindingUtil.inflate<VB>(
      LayoutInflater.from(parent.context),
      layoutRes,
      parent,
      false
    )

    return BaseViewHolder(view)*/
  }

  override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    val data = objectFromPosition(position)

    try {
      holder.bindData(data)
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
    val layoutInflater = LayoutInflater.from(viewGroup.context)
    return layoutInflater.inflate(viewType, viewGroup, false)
  }
}*/