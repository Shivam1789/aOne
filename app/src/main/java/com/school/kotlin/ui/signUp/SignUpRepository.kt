package com.school.kotlin.ui.signUp

import com.school.kotlin.api.service.ApiHelper
import com.school.kotlin.data.signUp.SignUpRequest
import com.school.kotlin.data.signUp.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by android on 19/2/18.
 *
 * Data Provider for the application
 */
object SignUpRepository {



    fun registerUser(successHandler: (SignUpResponse) -> Unit, failureHandler: (String) -> Unit, onFaliureHandler: (Throwable) -> Unit, request: SignUpRequest) {
        val webService = ApiHelper.createService()
        webService.registeration(request).enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>?, response: Response<SignUpResponse>?) {
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

            override fun onFailure(call: Call<SignUpResponse>?, t: Throwable?) {
                t?.let {
                    onFaliureHandler(it)
                }
            }
        })
    }


}