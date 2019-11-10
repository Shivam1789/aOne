package com.school.kotlin.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a!\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u001a0\u0010\u0007\u001a\u0002H\b\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u0001H\bH\u0086\b\u00a2\u0006\u0002\u0010\r\u001a\u001c\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a8\u0006\u0010"}, d2 = {"clearPref", "", "Landroid/content/SharedPreferences;", "edit", "operation", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "getValue", "T", "", "key", "", "defaultValue", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "setValue", "value", "app_devDebug"})
public final class PrefsKt {
    
    /**
     * * Created by android on 11/12/17.
     * * Take cares of the shared preferences
     */
    public static final void edit(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences $receiver, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.content.SharedPreferences.Editor, kotlin.Unit> operation) {
    }
    
    /**
     * * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
     */
    public static final void setValue(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.Object value) {
    }
    
    /**
     * * finds value on given key.
     * * [T] is the type of value
     * * @param defaultValue optional default value - will take null for strings,
     * * false for bool and -1 for numeric values if [defaultValue] is not specified
     */
    private static final <T extends java.lang.Object>T getValue(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences $receiver, java.lang.String key, T defaultValue) {
        return null;
    }
    
    public static final void clearPref(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences $receiver) {
    }
}