package com.besttyme.kotlin.utils.security;

import java.lang.System;

/**
 * * Created by android on 27/2/18.
 * *
 * * Encrypted Shared Preferences
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0003J\f\u0010\u0014\u001a\u00060\u0015R\u00020\u0000H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0003J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J$\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\'2\u0006\u0010\u000f\u001a\u00020\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\'H\u0017J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/besttyme/kotlin/utils/security/EncryptedPreferences;", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "algorithm", "", "fileName", "sFile", "sKey", "", "secretKey", "transformation", "contains", "", "key", "decode", "input", "decrypt", "ciphertext", "edit", "Lcom/besttyme/kotlin/utils/security/EncryptedPreferences$EncryptedEditor;", "encode", "encrypt", "cleartext", "generateAesKeyName", "generateAesKeyValue", "getAll", "", "getBoolean", "defaultValue", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringSet", "", "defaultValues", "registerOnSharedPreferenceChangeListener", "", "listener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "unregisterOnSharedPreferenceChangeListener", "EncryptedEditor", "app_devDebug"})
public final class EncryptedPreferences implements android.content.SharedPreferences {
    private final java.lang.String secretKey = "D3butS3cr3tK3y";
    private final java.lang.String fileName = "SecretPreferences";
    private final java.lang.String algorithm = "PBKDF2WithHmacSHA1";
    private final java.lang.String transformation = "AES";
    private final android.content.SharedPreferences sFile = null;
    private byte[] sKey;
    
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    private final java.lang.String generateAesKeyName(android.content.Context context) throws java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException {
        return null;
    }
    
    private final java.lang.String encode(byte[] input) {
        return null;
    }
    
    private final byte[] decode(java.lang.String input) {
        return null;
    }
    
    private final java.lang.String generateAesKeyValue() throws java.security.NoSuchAlgorithmException {
        return null;
    }
    
    private final java.lang.String encrypt(java.lang.String cleartext) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"GetInstance"})
    private final java.lang.String decrypt(java.lang.String ciphertext) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.Map<java.lang.String, java.lang.String> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getString(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultValue) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.HONEYCOMB)
    @java.lang.Override()
    public java.util.Set<java.lang.String> getStringSet(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> defaultValues) {
        return null;
    }
    
    @java.lang.Override()
    public int getInt(@org.jetbrains.annotations.NotNull()
    java.lang.String key, int defaultValue) {
        return 0;
    }
    
    @java.lang.Override()
    public long getLong(@org.jetbrains.annotations.NotNull()
    java.lang.String key, long defaultValue) {
        return 0L;
    }
    
    @java.lang.Override()
    public float getFloat(@org.jetbrains.annotations.NotNull()
    java.lang.String key, float defaultValue) {
        return 0.0F;
    }
    
    @java.lang.Override()
    public boolean getBoolean(@org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean defaultValue) {
        return false;
    }
    
    @java.lang.Override()
    public boolean contains(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.besttyme.kotlin.utils.security.EncryptedPreferences.EncryptedEditor edit() {
        return null;
    }
    
    @java.lang.Override()
    public void registerOnSharedPreferenceChangeListener(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences.OnSharedPreferenceChangeListener listener) {
    }
    
    @java.lang.Override()
    public void unregisterOnSharedPreferenceChangeListener(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences.OnSharedPreferenceChangeListener listener) {
    }
    
    public EncryptedPreferences(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * * Wrapper for Android's [SharedPreferences.Editor].
     *     *
     *     *
     *     * Used for modifying values in a [SharedPreferencesEncryption] object. All changes you make in an
     *     * editor are batched, and not copied back to the original [SharedPreferencesEncryption] until you
     *     * call [.commit] or [.apply].
     */
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0004\u001a\u00020\u0005H\u0017J\b\u0010\u0006\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016H\u0017J\u0010\u0010\u0017\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/besttyme/kotlin/utils/security/EncryptedPreferences$EncryptedEditor;", "Landroid/content/SharedPreferences$Editor;", "(Lcom/besttyme/kotlin/utils/security/EncryptedPreferences;)V", "mEditor", "apply", "", "clear", "commit", "", "putBoolean", "key", "", "value", "putFloat", "", "putInt", "", "putLong", "", "putString", "putStringSet", "values", "", "remove", "app_devDebug"})
    public final class EncryptedEditor implements android.content.SharedPreferences.Editor {
        private final android.content.SharedPreferences.Editor mEditor = null;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.content.SharedPreferences.Editor putString(@org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.String value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.HONEYCOMB)
        @java.lang.Override()
        public android.content.SharedPreferences.Editor putStringSet(@org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.Nullable()
        java.util.Set<java.lang.String> values) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.content.SharedPreferences.Editor putInt(@org.jetbrains.annotations.NotNull()
        java.lang.String key, int value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.content.SharedPreferences.Editor putLong(@org.jetbrains.annotations.NotNull()
        java.lang.String key, long value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.content.SharedPreferences.Editor putFloat(@org.jetbrains.annotations.NotNull()
        java.lang.String key, float value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.content.SharedPreferences.Editor putBoolean(@org.jetbrains.annotations.NotNull()
        java.lang.String key, boolean value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.content.SharedPreferences.Editor remove(@org.jetbrains.annotations.NotNull()
        java.lang.String key) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.content.SharedPreferences.Editor clear() {
            return null;
        }
        
        @java.lang.Override()
        public boolean commit() {
            return false;
        }
        
        @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.GINGERBREAD)
        @java.lang.Override()
        public void apply() {
        }
        
        public EncryptedEditor() {
            super();
        }
    }
}