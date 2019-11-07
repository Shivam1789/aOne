package com.school.kotlin.data.ForgotPassword

import com.google.gson.annotations.SerializedName

data class ForgotPasswordRequest(

	@field:SerializedName("mobile")
	var mobile: String? = null,

	@field:SerializedName("country_code")
	var countryCode: String? = null

	)