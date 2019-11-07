package com.school.kotlin.data.otp

import com.google.gson.annotations.SerializedName


data class Status(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("http_status_code")
	val httpStatusCode: Int? = null,

	@field:SerializedName("errorMessage")
	val errorMessage: String? = null
)