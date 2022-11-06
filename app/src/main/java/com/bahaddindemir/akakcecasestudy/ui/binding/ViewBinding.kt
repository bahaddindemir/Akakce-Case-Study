package com.bahaddindemir.akakcecasestudy.ui.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bahaddindemir.akakcecasestudy.util.convertToPrice

@BindingAdapter("bindDropRatio")
fun bindDropRatio(view: TextView, double: Double) {
  double.toInt().let {
    val price = "%$it"
    view.text = price
  }
}

@BindingAdapter("bindPrice")
fun bindPrice(view: TextView, double: Double) {
  double.toInt().let {
    val price = "${convertToPrice(it)} TL"
    view.text = price
  }
}

@BindingAdapter("bindCountOfPrice")
fun bindCountOfPrice(view: TextView, int: Int) {
  int.let {
    val countOfPrice = "$it satıcı >"
    view.text = countOfPrice
  }
}

@BindingAdapter("bindFollowCount")
fun bindFollowCount(view: TextView, int: Int) {
  int.let {
    val followCount = "${convertToPrice(it)}+ takip"
    view.text = followCount
  }
}