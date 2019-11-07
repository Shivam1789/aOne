package com.school.kotlin.data.error

import com.google.gson.annotations.SerializedName

data class ErrorResponse(

	@field:SerializedName("data")
	val data: Any? = null,

	@field:SerializedName("otp")
	val otp: String? = null,

	@field:SerializedName("status")
	val status: Status? = null
)