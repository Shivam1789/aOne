package com.school.kotlin.data.ForgotPassword

import com.google.gson.annotations.SerializedName

data class ForgotPasswordResponse(

	@field:SerializedName("data")
	val data: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Status? = null,

	@field:SerializedName("otp")
	val otp: String? = null
)