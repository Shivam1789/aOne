package com.school.kotlin.data.signUp

import com.google.gson.annotations.SerializedName

data class SignUpResponse(

	@field:SerializedName("data")
	val data: String? = null,

	@field:SerializedName("otp")
	val otp: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Status? = null
)