package com.school.kotlin.activities.navigational;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0007H\u0014J\b\u0010\u0018\u001a\u00020\u0007H\u0014J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\nH\u0007J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/school/kotlin/activities/navigational/NavigationalActivity;", "Lcom/school/kotlin/activities/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "mDrawerToggle", "Landroid/support/v7/app/ActionBarDrawerToggle;", "closeDrawer", "", "handleResponseCode", "response", "Lcom/school/kotlin/data/Status;", "init", "initNavigationDrawer", "moveToScreen", "type", "", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStop", "responseCode", "status", "setListener", "showLogOut", "app_devDebug"})
public final class NavigationalActivity extends com.school.kotlin.activities.BaseActivity implements android.view.View.OnClickListener {
    private android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void init() {
    }
    
    private final void setListener() {
    }
    
    /**
     * * This method will initialize navigation drawer and set toggle button and its action
     */
    private final void initNavigationDrawer() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void showLogOut() {
    }
    
    private final void moveToScreen(int type) {
    }
    
    /**
     * * This method will close the Drawer
     */
    private final void closeDrawer() {
    }
    
    /**
     * **************** handle API response code and manage action accordingly *******
     */
    public final void handleResponseCode(@org.jetbrains.annotations.NotNull()
    com.school.kotlin.data.Status response) {
    }
    
    /**
     * ************* get the api response here from response interceptor class ***********
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void responseCode(@org.jetbrains.annotations.NotNull()
    com.school.kotlin.data.Status status) {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public NavigationalActivity() {
        super();
    }
}