package com.bahaddindemir.akakcecasestudy.data.model.product

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainResult(
  @SerializedName("result") val result: Result?
): Parcelable

@Parcelize
data class Result(
  @SerializedName("nextUrl"           ) val nextUrl:            String?,
  @SerializedName("horizontalProducts") val horizontalProducts: List<HorizontalProduct>?,
  @SerializedName("products"          ) val products:           List<Product>?
): Parcelable

@Parcelize
data class HorizontalProduct(
  @SerializedName("code"         ) val code:          Int?,
  @SerializedName("imageUrl"     ) val imageUrl:      String?,
  @SerializedName("name"         ) val name:          String?,
  @SerializedName("dropRatio"    ) val dropRatio:     Double?,
  @SerializedName("price"        ) val price:         Double?,
  @SerializedName("countOfPrices") val countOfPrices: Int?,
  @SerializedName("followCount"  ) val followCount:   Int?
): Parcelable

@Parcelize
data class Product(
  @SerializedName("code"         ) val code:          Int?,
  @SerializedName("imageUrl"     ) val imageUrl:      String?,
  @SerializedName("name"         ) val name:          String?,
  @SerializedName("dropRatio"    ) val dropRatio:     Double?,
  @SerializedName("price"        ) val price:         Double?,
  @SerializedName("countOfPrices") val countOfPrices: Int?,
  @SerializedName("followCount"  ) val followCount:   Int?
) : Parcelable

