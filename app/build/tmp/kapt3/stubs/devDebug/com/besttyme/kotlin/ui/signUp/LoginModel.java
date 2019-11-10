package com.besttyme.kotlin.ui.signUp;

import java.lang.System;

/**
 * * Created by shivam on 15/6/18.
 * * model class for login
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/besttyme/kotlin/ui/signUp/LoginModel;", "Lcom/school/kotlin/api/model/MyViewModel;", "()V", "response", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/school/kotlin/data/Login/LoginResponse;", "getResponse", "()Landroid/arch/lifecycle/MutableLiveData;", "setResponse", "(Landroid/arch/lifecycle/MutableLiveData;)V", "loginData", "", "request", "Lcom/school/kotlin/data/Login/LoginRequest;", "app_devDebug"})
public final class LoginModel extends com.school.kotlin.api.model.MyViewModel {
    @org.jetbrains.annotations.NotNull()
    private android.arch.lifecycle.MutableLiveData<com.school.kotlin.data.Login.LoginResponse> response;
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.MutableLiveData<com.school.kotlin.data.Login.LoginResponse> getResponse() {
        return null;
    }
    
    public final void setResponse(@org.jetbrains.annotations.NotNull()
    android.arch.lifecycle.MutableLiveData<com.school.kotlin.data.Login.LoginResponse> p0) {
    }
    
    public final void loginData(@org.jetbrains.annotations.NotNull()
    com.school.kotlin.data.Login.LoginRequest request) {
    }
    
    public LoginModel() {
        super();
    }
}