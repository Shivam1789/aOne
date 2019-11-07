package com.school.kotlin.api.service

import Preferences
import android.util.Log
import com.readystatesoftware.chuck.ChuckInterceptor
import com.school.kotlin.application.BaseProject
import com.school.kotlin.data.ErrorsResponse
import com.school.kotlin.utils.Constants
import com.school.kotlin.utils.getValue
import com.school.kotlin.utils.security.BasicAuthInterceptor
import com.school.kotlin.utils.security.ResponseInterceptorterceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit





/**
 * Created by android on 3/11/17.
 * *
 */
object ApiHelper {
    private var mRetrofit: Retrofit
    private var mUserId:String?=null

    // Creating Retrofit Object
    init {
        val userId = Preferences.prefs?.getValue(Constants.ID, "")
        val password = Preferences.prefs?.getValue(Constants.TOKEN, "")
        mUserId=userId
        Log.e("user_token_intercepter","$userId + $password")
        mRetrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient(userId,password))
                .build()
    }

    private fun createSingleTonRatrofit()
    {
        val userId = Preferences.prefs?.getValue(Constants.ID, "")
        val password = Preferences.prefs?.getValue(Constants.TOKEN, "")
        mUserId=userId
        Log.e("user_token_intercepter","$userId + $password")
        mRetrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient(userId,password))
                .build()
    }

    // Creating OkHttpclient Object
    private fun getClient(userId:String?,password:String?): OkHttpClient {
        Log.e("user_getclient","$userId + $password")
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(ResponseInterceptorterceptor())
                .addInterceptor(ChuckInterceptor(BaseProject.getContext()))
                .addNetworkInterceptor(BasicAuthInterceptor(userId, password))
                .build()

    }



    //Creating service class for calling the web services
    fun createService(): WebService {


        createSingleTonRatrofit()

        return mRetrofit.create(WebService::class.java)
    }

    // Handling error messages returned by Apis
    fun handleApiError(body: ResponseBody?): String {
        var errorMsg = Constants.SOMETHING_WENT_WRONG
        try {
            val errorConverter: Converter<ResponseBody, ErrorsResponse> = mRetrofit.responseBodyConverter(ErrorsResponse::class.java, arrayOfNulls(0))
            val error: ErrorsResponse = errorConverter.convert(body)
            errorMsg = error.status?.errorMessage!!

        } catch (e: Exception) {
        }

        return errorMsg
    }

}