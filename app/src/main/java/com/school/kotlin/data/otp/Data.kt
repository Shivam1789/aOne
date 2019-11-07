package com.school.kotlin.data.otp


import com.google.gson.annotations.SerializedName


data class Data(

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("mobile")
	val mobile: String? = null,

	@field:SerializedName("profile_pic")
	val profilePic: String? = null,

	@field:SerializedName("notification_status")
	val notificationStatus: Boolean? = null,

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("accesstoken")
	val accesstoken: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)