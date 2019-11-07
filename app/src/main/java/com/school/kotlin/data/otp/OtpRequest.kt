package com.school.kotlin.data.otp

import com.google.gson.annotations.SerializedName

data class OtpRequest(

	@field:SerializedName("mobile")
	var mobile: String? = null,

	@field:SerializedName("otp")
	var otp: String? = null,

	@field:SerializedName("type")
	var type: String? = null,

	@field:SerializedName("new_number")
    var newPhoneNumber: String? = null,

	@field:SerializedName("country_code")
	var countryCode: String? = null
)