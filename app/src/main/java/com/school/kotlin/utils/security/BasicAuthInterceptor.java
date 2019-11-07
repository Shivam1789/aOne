package com.school.kotlin.utils.security;

import java.io.IOException;

import okhttp3.Credentials;

public class BasicAuthInterceptor implements okhttp3.Interceptor {
private String credentials;
public BasicAuthInterceptor(String user, String password) {
this.credentials = Credentials.basic(user, password);
    }
    @Override
public okhttp3.Response intercept(Chain chain) throws IOException {



        okhttp3.Request request = chain.request();
        okhttp3.Request authenticatedRequest = request.newBuilder()
                .header("Authorization", credentials).build();
return chain.proceed(authenticatedRequest);
    }
}