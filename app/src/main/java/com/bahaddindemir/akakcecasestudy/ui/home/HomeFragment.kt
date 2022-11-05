package com.bahaddindemir.akakcecasestudy.ui.home

import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.data.model.product.Product
import com.bahaddindemir.akakcecasestudy.databinding.FragmentHomeBinding
import com.bahaddindemir.akakcecasestudy.extension.showError
import com.bahaddindemir.akakcecasestudy.ui.base.BaseFragment
import com.bahaddindemir.akakcecasestudy.ui.viewholder.ProductViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), ProductViewHolder.Delegate {
  private val viewModel: HomeViewModel by viewModels()

  override fun getLayoutId() = R.layout.fragment_home

  override fun setBindingVariables() {
    //binding.viewModel = viewModel
    ///binding.coinsRecycler.adapter = coinAdapter
  }

  override fun setUpViews() {
    //loadProducts()
  }

  override fun setupObservers() {
    //setClickListeners()
    observeProductResource()
  }

  private fun observeProductResource() {
    /*viewModel.productLiveData.observe(viewLifecycleOwner) { resource ->
      when (resource.status) {
        Status.LOADING -> {
          showLoading()
          //binding.tableCoins.visibility = View.GONE
          //binding.coinsRecycler.visibility = View.GONE
        }
        Status.SUCCESS -> {
          hideLoading()
          //binding.tableCoins.visibility = View.VISIBLE
          //binding.coinsRecycler.visibility = View.VISIBLE
        }
        Status.ERROR -> {
          hideLoading()
          showError(getString(R.string.some_error))
        }
      }
    }*/
    viewModel.productLiveData.observe(viewLifecycleOwner) { resource ->
      Log.w("bahaddin", resource.body?.result.toString())
    }
  }

  //private fun loadProducts() = viewModel.postCoinsMarketsPage(page)

  override fun onItemClick(productItem: Product, view: View) {
    val bundle = bundleOf("productItem" to productItem)
    //view.findNavController().navigate(R.id.detail_fragment, bundle)
  }
}