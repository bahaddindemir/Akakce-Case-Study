package com.bahaddindemir.akakcecasestudy.util

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bahaddindemir.akakcecasestudy.R
import com.bumptech.glide.Glide

fun showLoadingDialog(activity: Activity?, hint: String?): Dialog? {
  if (activity == null || activity.isFinishing) {
    return null
  }
  val progressDialog = Dialog(activity)
  progressDialog.show()
  if (progressDialog.window != null) {
    progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
  }
  progressDialog.setContentView(R.layout.progress_dialog)
  val tvHint = progressDialog.findViewById<TextView>(R.id.tv_hint)
  if (!hint.isNullOrEmpty()) {
    tvHint.visibility = View.VISIBLE
    tvHint.text = hint
  } else {
    tvHint.visibility = View.GONE
  }

  progressDialog.setCancelable(false)
  progressDialog.setCanceledOnTouchOutside(false)
  progressDialog.show()

  return progressDialog
}

fun hideLoadingDialog(mProgressDialog: Dialog?, activity: Activity?) {
  if (activity != null && !activity.isFinishing && mProgressDialog != null && mProgressDialog.isShowing) {
    mProgressDialog.dismiss()
  }
}

fun setImageWithGlide(view: ImageView, imageUrl: String?) {
  Glide.with(view.context)
       .load(imageUrl)
       .into(view)
}

fun convertToPrice(int: Int): String {
  return (String.format("%,d", int))
}