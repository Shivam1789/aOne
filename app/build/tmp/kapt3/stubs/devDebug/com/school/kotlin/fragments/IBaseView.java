package com.school.kotlin.fragments;

import java.lang.System;

/**
 * * Created by android on 3/11/17.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/school/kotlin/fragments/IBaseView;", "", "hideProgressDialog", "", "onApiError", "error", "", "onServerError", "showProgressDialog", "app_devDebug"})
public abstract interface IBaseView {
    
    public abstract void showProgressDialog();
    
    public abstract void hideProgressDialog();
    
    public abstract void onServerError();
    
    public abstract void onApiError(@org.jetbrains.annotations.NotNull()
    java.lang.String error);
}