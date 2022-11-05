package com.bahaddindemir.akakcecasestudy.data.model.product

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailScreenResult(
  @SerializedName("result" ) val result: DetailResult
): Parcelable

@Parcelize
data class DetailResult(
  @SerializedName("mkName"        ) val mkName: String,
  @SerializedName("productName"   ) val productName: String,
  @SerializedName("badge"         ) val badge: String,
  @SerializedName("rating"        ) val rating: Double,
  @SerializedName("imageUrl"      ) val imageUrl: String,
  @SerializedName("storageOptions") val storageOptions: List<String>,
  @SerializedName("countOfPrices" ) val countOfPrices: Int,
  @SerializedName("price"         ) val price: Int,
  @SerializedName("freeShipping"  ) val freeShipping: Boolean,
  @SerializedName("lastUpdate"    ) val lastUpdate: String
): Parcelable