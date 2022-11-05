package com.bahaddindemir.akakcecasestudy.ui.splash

import android.os.Handler
import android.os.Looper
import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.databinding.ActivitySplashBinding
import com.bahaddindemir.akakcecasestudy.extension.openActivityAndClearStack
import com.bahaddindemir.akakcecasestudy.ui.base.BaseActivity
import com.bahaddindemir.akakcecasestudy.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
  override fun getLayoutId() = R.layout.activity_splash

  override fun setUpViews() {
    Handler(Looper.getMainLooper()).postDelayed({
      val targetActivity = HomeActivity::class.java
      openActivityAndClearStack(targetActivity)
    }, 2000)
  }
}