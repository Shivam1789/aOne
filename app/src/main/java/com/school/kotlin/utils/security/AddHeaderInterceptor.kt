package com.besttyme.kotlin.utils.security

import Preferences
import android.util.Log
import com.school.kotlin.utils.Constants
import com.school.kotlin.utils.getValue
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.*



/**
 * Created by shivam on 9/4/18.
 */


class AddHeaderInterceptor() : Interceptor {


    @Throws(IOException::class)

    override fun intercept(chain: Interceptor.Chain): Response {
        val userId = Preferences.prefs?.getValue(Constants.ID, "")
        val password = Preferences.prefs?.getValue(Constants.TOKEN, "")
        Log.e("user_token_intercepter","$userId + $password")

        val builder = chain.request().newBuilder()
        builder.addHeader("Username",userId)
        builder.addHeader("Password", password)
        return chain.proceed(builder.build())

    }

    fun getTimeZone():String{
        val tz = TimeZone.getDefault()
        val offset = tz.rawOffset
        val timeZone = String.format("%s%02d:%02d", if (offset >= 0) "+" else "-", offset / 3600000, offset / 60000 % 60)
        Log.e("newTimezone",timeZone)
        return timeZone
    }
   
}