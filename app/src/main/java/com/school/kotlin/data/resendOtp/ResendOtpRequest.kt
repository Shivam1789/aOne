package com.school.kotlin.data.resendOtp

import com.google.gson.annotations.SerializedName

data class ResendOtpRequest(

	@field:SerializedName("country_code")
	var countryCode: String? = null,

	@field:SerializedName("mobile")
	var mobile: String? = null,

	@field:SerializedName("new_number")
	var newPhoneNumber: String? = null,


	@field:SerializedName("type")
	var type: String? = null
)