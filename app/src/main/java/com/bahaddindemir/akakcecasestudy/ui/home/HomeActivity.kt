package com.bahaddindemir.akakcecasestudy.ui.home

import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.databinding.ActivityHomeBinding
import com.bahaddindemir.akakcecasestudy.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {
  override fun getLayoutId() = R.layout.activity_home
}