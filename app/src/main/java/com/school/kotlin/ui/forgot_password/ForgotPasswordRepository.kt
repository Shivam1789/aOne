package com.school.kotlin.ui.forgot_password

import com.school.kotlin.api.service.ApiHelper
import com.school.kotlin.data.ForgotPassword.ForgotPasswordRequest
import com.school.kotlin.data.ForgotPassword.ForgotPasswordResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by android on 19/2/18.
 *
 * Data Provider for the application
 */
object ForgotPasswordRepository {

    fun forgotPassword(successHandler: (ForgotPasswordResponse) -> Unit, failureHandler: (String) -> Unit, onFaliureHandler: (Throwable) -> Unit, request: ForgotPasswordRequest) {
        val webService = ApiHelper.createService()
        webService.forgotPassword(request).enqueue(object : Callback<ForgotPasswordResponse> {
            override fun onResponse(call: Call<ForgotPasswordResponse>?, response: Response<ForgotPasswordResponse>?) {
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

            override fun onFailure(call: Call<ForgotPasswordResponse>?, t: Throwable?) {
                t?.let {
                    onFaliureHandler(it)
                }
            }
        })
    }


}