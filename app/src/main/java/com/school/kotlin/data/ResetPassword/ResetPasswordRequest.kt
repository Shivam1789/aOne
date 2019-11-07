package com.school.kotlin.data.ResetPassword

import com.google.gson.annotations.SerializedName

data class ResetPasswordRequest(

	@field:SerializedName("password")
	var password: String? = null,

	@field:SerializedName("mobile")
	var mobile: String? = null
)