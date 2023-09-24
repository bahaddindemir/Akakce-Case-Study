package com.bahaddindemir.akakcecasestudy.ui.main

import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.databinding.ActivityMainBinding
import com.bahaddindemir.akakcecasestudy.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
  override fun getLayoutId() = R.layout.activity_main
}