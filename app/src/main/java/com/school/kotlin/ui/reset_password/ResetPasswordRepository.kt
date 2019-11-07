package com.school.kotlin.ui.reset_password

import com.school.kotlin.api.service.ApiHelper
import com.school.kotlin.data.ResetPassword.ResetPasswordRequest
import com.school.kotlin.data.ResetPassword.ResetPasswordResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by android on 19/2/18.
 *
 * Data Provider for the application
 */
object ResetPasswordRepository {



    fun resetPassword(successHandler: (ResetPasswordResponse) -> Unit, failureHandler: (String) -> Unit, onFaliureHandler: (Throwable) -> Unit, request: ResetPasswordRequest) {
        val webService = ApiHelper.createService()
        webService.resetPassword(request).enqueue(object : Callback<ResetPasswordResponse> {
            override fun onResponse(call: Call<ResetPasswordResponse>?, response: Response<ResetPasswordResponse>?) {
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

            override fun onFailure(call: Call<ResetPasswordResponse>?, t: Throwable?) {
                t?.let {
                    onFaliureHandler(it)
                }
            }
        })
    }


}