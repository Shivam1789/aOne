package com.school.kotlin.data.error

import com.google.gson.annotations.SerializedName

/**
 * Created by android on 3/11/17.
 */
data class Status(@SerializedName("status") val status: Int, @SerializedName("message") val message: String)