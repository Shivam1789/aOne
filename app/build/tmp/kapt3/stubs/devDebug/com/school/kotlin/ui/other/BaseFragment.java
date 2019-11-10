package com.school.kotlin.ui.other;

import java.lang.System;

/**
 * * Created by android on 2/11/17.
 * * *
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0017H\u0004J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001f\u001a\u00020\u0017H\u0004J\u0006\u0010 \u001a\u00020\u0017J\u0012\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001c\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0016\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020\u001aJ$\u0010(\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0004J(\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u000203H\u0004J\u0015\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0002\u00106J\u000e\u00107\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0006J$\u00108\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00062\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060:2\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020\u0017J\u0010\u0010>\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2 = {"Lcom/school/kotlin/ui/other/BaseFragment;", "Landroid/support/v4/app/Fragment;", "()V", "PERMISSION_REQUEST", "", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "alertDialog", "Landroid/app/AlertDialog;", "mActivity", "Landroid/support/v4/app/FragmentActivity;", "mContent", "Landroid/view/View;", "getMContent", "()Landroid/view/View;", "setMContent", "(Landroid/view/View;)V", "mProgressDialog", "Landroid/app/Dialog;", "addFragment", "", "fragment", "addToBackStack", "", "dismissAlertDialog", "getFormatedTimeFromUtc", "dateString", "dateFormat", "goBack", "hideProgress", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "replaceFragment", "animate", "setProfileImage", "imagePath", "imageView_profile", "Landroid/widget/ImageView;", "progressBar", "Landroid/widget/ProgressBar;", "showAlertDialogBox", "title", "message", "inconId", "onClickListener", "Landroid/view/View$OnClickListener;", "showLoading", "show", "(Ljava/lang/Boolean;)V", "showMessage", "showOptionDialog", "itemList", "Ljava/util/ArrayList;", "optionSelected", "Lcom/school/kotlin/callBack/OptionSelected;", "showProgress", "showSnackBar", "app_devDebug"})
public class BaseFragment extends android.support.v4.app.Fragment {
    private final java.lang.String TAG = null;
    @org.jetbrains.annotations.Nullable()
    private android.view.View mContent;
    private android.support.v4.app.FragmentActivity mActivity;
    private android.app.AlertDialog alertDialog;
    private android.app.Dialog mProgressDialog;
    private final int PERMISSION_REQUEST = 121;
    private java.util.HashMap _$_findViewCache;
    
    protected final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getMContent() {
        return null;
    }
    
    public final void setMContent(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void showLoading(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean show) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.Nullable()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void showSnackBar(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    /**
     * * Add fragment with or without addToBackStack
     *     *
     *     * @param fragment       which needs to be attached
     *     * @param addToBackStack is fragment needed to backstack
     */
    public final void addFragment(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.Fragment fragment, boolean addToBackStack) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFormatedTimeFromUtc(@org.jetbrains.annotations.Nullable()
    java.lang.String dateString, @org.jetbrains.annotations.Nullable()
    java.lang.String dateFormat) {
        return null;
    }
    
    public final void replaceFragment(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.Fragment fragment, boolean animate) {
    }
    
    protected final void setProfileImage(@org.jetbrains.annotations.Nullable()
    java.lang.String imagePath, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView_profile, @org.jetbrains.annotations.Nullable()
    android.widget.ProgressBar progressBar) {
    }
    
    protected final void goBack() {
    }
    
    /**
     * * show progress view
     */
    public final void showProgress() {
    }
    
    /**
     * * hide progress view
     */
    public final void hideProgress() {
    }
    
    public final void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * * show alert dialog box
     *     * @param title   title needs to be shown on the Alert
     *     * @param message message needs to be shown on the alert
     *     * @param inconId Icon for the dialog
     */
    protected final void showAlertDialogBox(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String message, int inconId, @org.jetbrains.annotations.NotNull()
    android.view.View.OnClickListener onClickListener) {
    }
    
    public final void showOptionDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> itemList, @org.jetbrains.annotations.NotNull()
    com.school.kotlin.callBack.OptionSelected optionSelected) {
    }
    
    /**
     * * dismiss alert dialog box
     */
    protected final void dismissAlertDialog() {
    }
    
    public BaseFragment() {
        super();
    }
}