package com.bahaddindemir.akakcecasestudy.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.bahaddindemir.akakcecasestudy.R
import com.bahaddindemir.akakcecasestudy.databinding.FragmentSplashBinding
import com.bahaddindemir.akakcecasestudy.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {
  override fun getLayoutId() = R.layout.fragment_splash

  override fun setUpViews() {
    Handler(Looper.getMainLooper()).postDelayed({
      findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
    }, 2000)
  }
}