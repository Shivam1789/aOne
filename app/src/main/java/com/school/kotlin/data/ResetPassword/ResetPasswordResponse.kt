package com.school.kotlin.data.ResetPassword

import com.google.gson.annotations.SerializedName

data class ResetPasswordResponse(

	@field:SerializedName("data")
	val data: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Status? = null
)