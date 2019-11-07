package com.school.kotlin.ui.login

import com.school.kotlin.api.service.ApiHelper
import com.school.kotlin.data.Login.LoginRequest
import com.school.kotlin.data.Login.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by android on 19/2/18.
 *
 * Data Provider for the application
 */
object LoginRepository {

    fun loginUser(successHandler: (LoginResponse) -> Unit, failureHandler: (String) -> Unit, onFaliureHandler: (Throwable) -> Unit, request: LoginRequest) {
        val webService = ApiHelper.createService()
        webService.login(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
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

            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                t?.let {
                    onFaliureHandler(it)
                }
            }
        })
    }
}