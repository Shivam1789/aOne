package com.school.kotlin.data.Login

import com.google.gson.annotations.SerializedName
import com.school.kotlin.data.otp.Data


data class LoginResponse(

		@field:SerializedName("data")
	   val data: Data? = null,

		@field:SerializedName("message")
	val message: String? = null,

		@field:SerializedName("status")
	val status: Status? = null
)