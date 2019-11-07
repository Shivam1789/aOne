package com.school.kotlin.ui.otp

import com.school.kotlin.api.service.ApiHelper
import com.school.kotlin.data.otp.OtpRequest
import com.school.kotlin.data.otp.OtpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by android on 19/2/18.
 *
 * Data Provider for the application
 */
object OtpRepository {



    fun sendOtp(successHandler: (OtpResponse) -> Unit, failureHandler: (String) -> Unit, onFaliureHandler: (Throwable) -> Unit, request: OtpRequest) {
        val webService = ApiHelper.createService()
        webService.otp(request).enqueue(object : Callback<OtpResponse> {
            override fun onResponse(call: Call<OtpResponse>?, response: Response<OtpResponse>?) {
                response?.body()?.let {
                    successHandler(it)

                }
                if (response?.code() == 401) {

                } else {
                    response?.errorBody()?.let {
                        val error = ApiHelper.handleApiError(response.errorBody()!!)
                        failureHandler(error)
                    }
                }
            }

            override fun onFailure(call: Call<OtpResponse>?, t: Throwable?) {
                t?.let {
                    onFaliureHandler(it)
                }
            }
        })
    }

}