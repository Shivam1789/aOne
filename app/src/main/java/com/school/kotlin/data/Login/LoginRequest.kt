package com.school.kotlin.data.Login

import com.google.gson.annotations.SerializedName

data class LoginRequest(

	@field:SerializedName("password")
    var password: String? = null,

	@field:SerializedName("mobile")
	var mobile: String? = null
)