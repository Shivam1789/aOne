package com.school.kotlin.data.signUp

import com.google.gson.annotations.SerializedName

data class SignUpRequest(

	@field:SerializedName("country_code")
	var countryCode: String? = null,

	@field:SerializedName("password")
	var password: String? = null,

	@field:SerializedName("mobile")
	var mobile: String? = null,

	@field:SerializedName("last_name")
	var lastName: String? = null,

	@field:SerializedName("first_name")
	var firstName: String? = null,

	@field:SerializedName("email")
	var email: String? = null
)