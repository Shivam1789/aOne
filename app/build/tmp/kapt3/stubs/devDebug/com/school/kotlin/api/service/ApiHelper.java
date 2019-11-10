package com.school.kotlin.api.service;

import java.lang.System;

/**
 * * Created by android on 3/11/17.
 * * *
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/school/kotlin/api/service/ApiHelper;", "", "()V", "mRetrofit", "Lretrofit2/Retrofit;", "mUserId", "", "createService", "Lcom/school/kotlin/api/service/WebService;", "createSingleTonRatrofit", "", "getClient", "Lokhttp3/OkHttpClient;", "userId", "password", "handleApiError", "body", "Lokhttp3/ResponseBody;", "app_devDebug"})
public final class ApiHelper {
    private static retrofit2.Retrofit mRetrofit;
    private static java.lang.String mUserId;
    public static final com.school.kotlin.api.service.ApiHelper INSTANCE = null;
    
    private final void createSingleTonRatrofit() {
    }
    
    private final okhttp3.OkHttpClient getClient(java.lang.String userId, java.lang.String password) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.school.kotlin.api.service.WebService createService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String handleApiError(@org.jetbrains.annotations.Nullable()
    okhttp3.ResponseBody body) {
        return null;
    }
    
    private ApiHelper() {
        super();
    }
}