package com.bahaddindemir.akakcecasestudy.ui.home

import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
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

  override fun getLayoutId() = R.layout.fragment_home

  override fun setBindingVariables() {
    binding.viewModel = viewModel
    binding.productRecycler.adapter = productAdapter
    binding.viewpager.adapter = horizontalProductAdapter
  }

  override fun setupObservers() {
    observeProductResource()
  }

  private fun observeProductResource() {
    viewModel.productLiveData.observe(viewLifecycleOwner) { resource ->
      Log.w("bahaddin", resource.body?.result.toString())
      showLoading()
      if (resource.isSuccessful) {
        hideLoading()
        binding.productRecycler.visibility = View.VISIBLE
      } else {
        hideLoading()
        showError(getString(R.string.some_error))
      }
    }
  }

  override fun onItemClick(productItem: Product, view: View) {
    openProductDetail(productItem.code, view)
  }

  override fun onItemClick(horizontalProduct: HorizontalProduct, view: View) {
    openProductDetail(horizontalProduct.code, view)
  }

  private fun openProductDetail(code: Int?, view: View) {
    val bundle = bundleOf("productCode" to code)
    view.findNavController().navigate(R.id.detail_fragment, bundle)
  }
}