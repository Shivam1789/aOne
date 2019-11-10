package com.school.kotlin.utils;

import java.lang.System;

/**
 * * Created by android on 2/11/17.
 * * *
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0004J\u0010\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#J\u000e\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020\n2\u0006\u0010\'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u000fJ\u0018\u0010*\u001a\u00020+2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010,\u001a\u00020\u0004J\u0018\u0010-\u001a\u00020+2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010,\u001a\u00020\u0004J\u0016\u0010.\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/school/kotlin/utils/Utils;", "", "()V", "FILE_NAME", "", "getFILE_NAME", "()Ljava/lang/String;", "mLastClickTime", "", "checkPermission", "", "context", "Landroid/support/v4/app/Fragment;", "customPrefs", "Landroid/content/SharedPreferences;", "Landroid/content/Context;", "defaultPrefs", "formatDate", "dateStr", "getDOB", "", "textView", "Landroid/widget/TextView;", "getOriginalImagePath", "fragmentActivity", "Landroid/support/v4/app/FragmentActivity;", "getPathFromURI", "uri", "Landroid/net/Uri;", "hideKeyboard", "ctx", "isEmailValid", "email", "isNetworkAvailable", "content", "Landroid/view/View;", "isPasswordValid", "password", "isPermissionDeniedPermanently", "fragment", "permission", "logout", "showCustomSnackbar", "Landroid/support/design/widget/Snackbar;", "toast", "showSnackbar", "showToast", "message", "singleClick", "app_devDebug"})
public final class Utils {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FILE_NAME = "BaseProject";
    private static long mLastClickTime;
    public static final com.school.kotlin.utils.Utils INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFILE_NAME() {
        return null;
    }
    
    public final void showToast(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences defaultPrefs(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences customPrefs(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * * Show toast.
     *     *
     *     * @param toast String value which needs to shown in the toast.
     *     * @description if you want to print a toast just call this method and pass
     *     * what you want to be shown.
     */
    @org.jetbrains.annotations.NotNull()
    public final synchronized android.support.design.widget.Snackbar showSnackbar(@org.jetbrains.annotations.Nullable()
    android.view.View content, @org.jetbrains.annotations.NotNull()
    java.lang.String toast) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final synchronized android.support.design.widget.Snackbar showCustomSnackbar(@org.jetbrains.annotations.Nullable()
    android.view.View content, @org.jetbrains.annotations.NotNull()
    java.lang.String toast) {
        return null;
    }
    
    public final void logout(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * * Is email valid.
     *     *
     *     * @param email Pass a email in string format and this method check if it is
     *     * a valid address or not.
     *     * @return True if email is valid otherwise false.
     */
    public final boolean isEmailValid(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return false;
    }
    
    /**
     * * Is online.
     *     *
     *     * @return True, if device is having a Internet connection available.
     */
    public final boolean isNetworkAvailable(@org.jetbrains.annotations.Nullable()
    android.view.View content) {
        return false;
    }
    
    public final boolean singleClick() {
        return false;
    }
    
    public final boolean isPasswordValid(@org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return false;
    }
    
    public final synchronized void getDOB(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.TextView textView) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String formatDate(@org.jetbrains.annotations.Nullable()
    java.lang.String dateStr) {
        return null;
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.JELLY_BEAN)
    public final boolean checkPermission(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.Fragment context) {
        return false;
    }
    
    public final boolean isPermissionDeniedPermanently(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final synchronized java.lang.String getOriginalImagePath(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.FragmentActivity fragmentActivity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPathFromURI(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.net.Uri uri) {
        return null;
    }
    
    private Utils() {
        super();
    }
}