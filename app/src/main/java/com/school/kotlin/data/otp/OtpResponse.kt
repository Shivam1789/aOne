package com.school.kotlin.data.otp


import com.google.gson.annotations.SerializedName



data class OtpResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Status? = null
)