package com.bahaddindemir.akakcecasestudy.ui.home

import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.data.model.product.HorizontalProduct
import com.bahaddindemir.akakcecasestudy.data.model.product.Product
import com.bahaddindemir.akakcecasestudy.databinding.FragmentHomeBinding
import com.bahaddindemir.akakcecasestudy.extension.showError
import com.bahaddindemir.akakcecasestudy.ui.adapter.HorizontalProductAdapter
import com.bahaddindemir.akakcecasestudy.ui.adapter.ProductAdapter
import com.bahaddindemir.akakcecasestudy.ui.base.BaseFragment
import com.bahaddindemir.akakcecasestudy.ui.viewholder.HorizontalProductViewHolder
import com.bahaddindemir.akakcecasestudy.ui.viewholder.ProductViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), ProductViewHolder.Delegate, HorizontalProductViewHolder.Delegate {
  private val viewModel: HomeViewModel by viewModels()
  private var productAdapter           = ProductAdapter(this)
  private var horizontalProductAdapter = HorizontalProductAdapter(this)
  private var nextUrl = ""

  override fun getLayoutId() = R.layout.fragment_home

  override fun setBindingVariables() {
    binding.viewModel = viewModel
    binding.productRecycler.adapter = productAdapter
    binding.viewpager.adapter = horizontalProductAdapter
  }

  override fun setUpViews() {
    binding.productRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
      override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)

        if (!recyclerView.canScrollVertically(1) && nextUrl.isNotEmpty()) {
          getNextResults(nextUrl)
          nextUrl = ""
        }
      }
    })
  }

  override fun setupObservers() {
    observeProductResource()
  }

  private fun observeProductResource() {
    viewModel.productLiveData.observe(viewLifecycleOwner) { resource ->
      Log.w(tag, resource?.result.toString())
      showLoading()
      if (resource != null) {
        hideLoading()
        binding.productRecycler.visibility = View.VISIBLE

        resource.result?.nextUrl?.let {
          nextUrl = it
        }
      } else {
        hideLoading()
        showError(getString(R.string.some_error))
      }
    }
    viewModel.nextProductLiveData.observe(viewLifecycleOwner) { resource ->
      if (resource != null) {
        productAdapter.addProductItemList(resource.result?.products)

        resource.result?.nextUrl?.let {
          nextUrl = it
        }
      }
    }
  }

  private fun getNextResults(nextUrl: String) {
    viewModel.getNextResult(nextUrl)
  }

  override fun onItemClick(productItem: Product, view: View) {
    openProductDetail(productItem.code, view)
  }

  override fun onItemClick(horizontalProduct: HorizontalProduct, view: View) {
    openProductDetail(horizontalProduct.code, view)
  }

  private fun openProductDetail(code: Int?, view: View) {
    val bundle = bundleOf("productCode" to code)
    view.findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
  }
}