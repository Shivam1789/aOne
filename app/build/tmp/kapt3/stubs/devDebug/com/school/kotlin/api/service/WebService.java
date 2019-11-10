package com.school.kotlin.api.service;

import java.lang.System;

/**
 * * Created by Shivam on 3/11/17.
 * *  All web services are declared here
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH\'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\fH\'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000fH\'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/school/kotlin/api/service/WebService;", "", "forgotPassword", "Lretrofit2/Call;", "Lcom/school/kotlin/data/ForgotPassword/ForgotPasswordResponse;", "request", "Lcom/school/kotlin/data/ForgotPassword/ForgotPasswordRequest;", "login", "Lcom/school/kotlin/data/Login/LoginResponse;", "Lcom/school/kotlin/data/Login/LoginRequest;", "otp", "Lcom/school/kotlin/data/otp/OtpResponse;", "Lcom/school/kotlin/data/otp/OtpRequest;", "registeration", "Lcom/school/kotlin/data/signUp/SignUpResponse;", "Lcom/school/kotlin/data/signUp/SignUpRequest;", "resetPassword", "Lcom/school/kotlin/data/ResetPassword/ResetPasswordResponse;", "Lcom/school/kotlin/data/ResetPassword/ResetPasswordRequest;", "app_devDebug"})
public abstract interface WebService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "registration")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    public abstract retrofit2.Call<com.school.kotlin.data.signUp.SignUpResponse> registeration(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.school.kotlin.data.signUp.SignUpRequest request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "verifyotp")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    public abstract retrofit2.Call<com.school.kotlin.data.otp.OtpResponse> otp(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.school.kotlin.data.otp.OtpRequest request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "login")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    public abstract retrofit2.Call<com.school.kotlin.data.Login.LoginResponse> login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.school.kotlin.data.Login.LoginRequest request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "forgotpassword")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    public abstract retrofit2.Call<com.school.kotlin.data.ForgotPassword.ForgotPasswordResponse> forgotPassword(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.school.kotlin.data.ForgotPassword.ForgotPasswordRequest request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "resetpassword")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    public abstract retrofit2.Call<com.school.kotlin.data.ResetPassword.ResetPasswordResponse> resetPassword(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.school.kotlin.data.ResetPassword.ResetPasswordRequest request);
}