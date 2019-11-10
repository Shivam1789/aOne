package com.school.kotlin.cryptography;

import java.lang.System;

/**
 * * Created by android on 18/12/17.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/school/kotlin/cryptography/Encryption;", "", "()V", "key", "", "transformation", "", "decrypt", "istream", "Ljava/io/InputStream;", "encrypt", "", "object", "Ljava/io/Serializable;", "ostream", "Ljava/io/OutputStream;", "app_devDebug"})
public final class Encryption {
    private final byte[] key = null;
    private final java.lang.String transformation = "AES/ECB/PKCS5Padding";
    
    public final void encrypt(@org.jetbrains.annotations.NotNull()
    java.io.Serializable object, @org.jetbrains.annotations.NotNull()
    java.io.OutputStream ostream) throws java.io.IOException, java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object decrypt(@org.jetbrains.annotations.NotNull()
    java.io.InputStream istream) throws java.io.IOException, java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException {
        return null;
    }
    
    public Encryption() {
        super();
    }
}