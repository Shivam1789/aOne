package com.school.kotlin.data

import com.google.gson.annotations.SerializedName

data class ErrorsResponse(

	@field:SerializedName("data")
	val data: Any? = null,

	@field:SerializedName("otp")
	val otp: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Status? = null
)