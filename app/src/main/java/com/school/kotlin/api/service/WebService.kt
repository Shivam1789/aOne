package com.school.kotlin.api.service

import com.school.kotlin.data.ForgotPassword.ForgotPasswordRequest
import com.school.kotlin.data.ForgotPassword.ForgotPasswordResponse
import com.school.kotlin.data.Login.LoginRequest
import com.school.kotlin.data.Login.LoginResponse
import com.school.kotlin.data.ResetPassword.ResetPasswordRequest
import com.school.kotlin.data.ResetPassword.ResetPasswordResponse
import com.school.kotlin.data.otp.OtpRequest
import com.school.kotlin.data.otp.OtpResponse
import com.school.kotlin.data.signUp.SignUpRequest
import com.school.kotlin.data.signUp.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST



/**
 * Created by Shivam on 3/11/17.
 *  All web services are declared here
 */
interface WebService {


    @Headers("Accept: " + "application/json")
    @POST("registration")
    fun registeration(@Body request: SignUpRequest): Call<SignUpResponse>


    @Headers("Accept: " + "application/json")
    @POST("verifyotp")
    fun otp(@Body request: OtpRequest): Call<OtpResponse>


    @Headers("Accept: " + "application/json")
    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>


    @Headers("Accept: " + "application/json")
    @POST("forgotpassword")
    fun forgotPassword(@Body request: ForgotPasswordRequest): Call<ForgotPasswordResponse>

    @Headers("Accept: " + "application/json")
    @POST("resetpassword")
    fun resetPassword(@Body request: ResetPasswordRequest): Call<ResetPasswordResponse>



}