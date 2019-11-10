package com.school.kotlin.ui.signUp;

import java.lang.System;

/**
 * * Created by android on 19/2/18.
 * *
 * * Data Provider for the application
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2 = {"Lcom/school/kotlin/ui/signUp/SignUpRepository;", "", "()V", "registerUser", "", "successHandler", "Lkotlin/Function1;", "Lcom/school/kotlin/data/signUp/SignUpResponse;", "failureHandler", "", "onFaliureHandler", "", "request", "Lcom/school/kotlin/data/signUp/SignUpRequest;", "app_devDebug"})
public final class SignUpRepository {
    public static final com.school.kotlin.ui.signUp.SignUpRepository INSTANCE = null;
    
    public final void registerUser(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.school.kotlin.data.signUp.SignUpResponse, kotlin.Unit> successHandler, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> failureHandler, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onFaliureHandler, @org.jetbrains.annotations.NotNull()
    com.school.kotlin.data.signUp.SignUpRequest request) {
    }
    
    private SignUpRepository() {
        super();
    }
}