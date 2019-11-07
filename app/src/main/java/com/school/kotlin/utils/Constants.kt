package com.school.kotlin.utils

import com.school.kotlin.BuildConfig

/**
 * Created by android on 2/11/17.
 */
object Constants {


    const val IS_TUTORIAL_SEEN = "is_tutorial_seen"
    const val IS_ENABLE_LOCATION = "is_enable_location"
    const val IS_LOGGED_IN = "is_logged_in"
    const val BASE_URL =  BuildConfig.BASE_URL
    const val TOKEN = "Password"
    const val ID = "id"
    const val CODE = "CountryCode"
    const val PHONE = "Phone"

    const val REQUEST_CAMERA = 1
    const val REQUEST_GALLERY = 2

    const val PERMISSION_READ_EXTERNAL_STORAGE = 123
    const val SPLASH_TIME_OUT: Long = 4000;

    const val FRAGMENT_TYPE = "fragment_type"

    const val ADD_STUDENT = 22

    const val FAILURE_TIME_OUT_ERROR = "Request time out!"
    const val FAILURE_SOMETHING_WENT_WRONG = "Something went wrong please try again later!"
    const val FAILURE_SERVER_NOT_RESPONDING = "Oops! looks like we are having internal problems. Please try again later."
    const val FAILURE_INTERNET_CONNECTION = "Internet connection appears to be offline. Please check your network settings."
    const val SESSION_EXPIRED = "Sorry, looks like you are logged in another device with the same user."
    const val SOMETHING_WENT_WRONG = "Something went wrong please try again later!"

    const val REQUEST_SELECT_PLACE = 500


    internal interface httpcodes {
        companion object {
            val STATUS_OK = 200
            val STATUS_BAD_REQUEST = 400
            val STATUS_SESSION_EXPIRED = 401
            val STATUS_PLAN_EXPIRED = 403
            val STATUS_VALIDATION_ERROR = 404
            val STATUS_SERVER_ERROR = 500
            val STATUS_UNKNOWN_ERROR = 503
            val STATUS_API_VALIDATION_ERROR = 422

        }
    }

    //enum class for navigation drawer
    enum class TYPE(val type: Int) {
        ADDSTUDENT(1)
    }


    const val MOBILE_NUMBER = "mobile_no"

    const val COUNTRY_CODE = "country_code"

    const val SAVEPROFILE = "Profile_Save"

    const val FROM_FORGOT = "from_forgot"
    const val SNACK_BAR_DURATION = 2500
    const val PHONE_NUMBER = "phone_number"

    const val CHECKED_UNCHECKED = "checked_remember"

}