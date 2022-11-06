package com.bahaddindemir.akakcecasestudy.data.model

import android.util.Log
import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException

@Suppress("JoinDeclarationAndAssignment")
class ApiResponse<T> {
  val code: Int
  val body: T?
  private val gson: Gson
  private val envelope: Envelope?

  val isSuccessful: Boolean
    get() = code in 200..300

  init {
    gson = Gson()
  }

  constructor(error: Throwable) {
    code = 500
    body = null
    envelope = Envelope(error.message.toString(), "")
  }

  constructor(response: Response<T>) {
    code = response.code()
    if (response.isSuccessful) {
      body = response.body()
      envelope = null
    } else {
      var message: String? = null
      response.errorBody()?.let {
        try {
          message = response.errorBody()!!.string()
        } catch (ignored: IOException) {
          Log.w(this.toString(), "error while parsing response " + ignored.message)
        }
      }

      message?.apply {
        if (isNullOrEmpty() || trim { it <= ' ' }.isEmpty()) {
          message = response.message()
        }
      }

      envelope = gson.fromJson(message, Envelope::class.java)
      body = null
    }
  }
}