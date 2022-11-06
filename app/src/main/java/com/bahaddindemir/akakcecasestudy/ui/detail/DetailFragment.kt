package com.bahaddindemir.akakcecasestudy.ui.detail

import android.view.View
import androidx.fragment.app.viewModels
import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.data.model.product.DetailResult
import com.bahaddindemir.akakcecasestudy.data.model.product.Product
import com.bahaddindemir.akakcecasestudy.databinding.FragmentDetailBinding
import com.bahaddindemir.akakcecasestudy.extension.showError
import com.bahaddindemir.akakcecasestudy.ui.base.BaseFragment
import com.bahaddindemir.akakcecasestudy.util.convertToPrice
import com.bahaddindemir.akakcecasestudy.util.setImageWithGlide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {
  private val viewModel: DetailViewModel by viewModels()

  private lateinit var productItem: Product

  override fun getLayoutId() = R.layout.fragment_detail

  override fun getFragmentArguments() {
    super.getFragmentArguments()
    val bundle = arguments
    bundle?.let {
      productItem = it.get("productItem") as Product
      loadCoinDetail(productItem)
    }
  }

  override fun setupObservers() {
    observeProductDetailData()
  }

  private fun observeProductDetailData() {
    viewModel.productDetailLiveData.observe(viewLifecycleOwner) { resource ->
      showLoading()
      if (resource.isSuccessful) {
        hideLoading()
        resource.body?.result?.let {
          handleCoinDetailDataOnSuccess(it)
        }
      } else {
        hideLoading()
        showError(getString(R.string.some_error))
      }
    }
  }

  private fun handleCoinDetailDataOnSuccess(detailResult: DetailResult) {
    detailResult.let {
      binding.productDetailMKName.text        = it.mkName
      binding.productDetailName.text          = it.productName
      binding.productBadge.text               = it.badge
      binding.productDetailCountOfPrices.text = resources.getString(R.string.detail_count_of_prices, it.countOfPrices)
      binding.productDetailPrice.text         = resources.getString(R.string.price_string, convertToPrice(it.price))
      binding.productDetailLastUpdate.text    = resources.getString(R.string.last_update, it.lastUpdate)

      if (it.freeShipping) {
        binding.productDetailFreeShipping.visibility = View.VISIBLE
      } else {
        binding.productDetailFreeShipping.visibility = View.GONE
      }

      setStorageOptions(it.storageOptions)
      setImageWithGlide(binding.productDetailImage, it.imageUrl)
    }
  }

  private fun setStorageOptions(options: List<String>) {
    binding.storageOption1.text = options[0]
    binding.storageOption2.text = options[1]
    binding.storageOption3.text = options[2]
  }

  private fun loadCoinDetail(productItem: Product?) {
    productItem?.let {
      viewModel.postProductDetailId(it.code!!)
    }
  }
}