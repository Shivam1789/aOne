package com.besttyme.kotlin.utils.security

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.provider.Settings
import android.util.Base64
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.InvalidKeySpecException
import java.util.*
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

/**
 * Created by android on 27/2/18.
 *
 * Encrypted Shared Preferences
 */
 class EncryptedPreferences(context: Context) : SharedPreferences {
    private val secretKey = "D3butS3cr3tK3y"
    private val fileName = "SecretPreferences"
    private val algorithm = "PBKDF2WithHmacSHA1"
    private val transformation = "AES"
    private val sFile: SharedPreferences
    private var sKey: ByteArray? = null

    init {
        sFile = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
        // Initialize encryption/decryption key
        try {
            val key = generateAesKeyName(context)
            var value = sFile.getString(key, null)
            if (value == null) {
                value = generateAesKeyValue()
                sFile.edit()?.putString(key, value)?.apply()
            }
            sKey = decode(value)
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }

    }


    @SuppressLint("HardwareIds")
    @Throws(InvalidKeySpecException::class, NoSuchAlgorithmException::class)
    private fun generateAesKeyName(context: Context): String {
        val password = secretKey.toCharArray()
        val salt = Settings.Secure.getString(context.contentResolver,
                Settings.Secure.ANDROID_ID).toByteArray()
        // Number of PBKDF2 hardening rounds to use, larger values increase
        // computation time, you should select a value that causes
        // computation to take >100ms
        val iterations = 1000
        // Generate a 256-bit key
        val keyLength = 256
        val spec = PBEKeySpec(password, salt, iterations, keyLength)
        return encode(SecretKeyFactory.getInstance(algorithm)
                .generateSecret(spec).encoded)
    }


    private fun encode(input: ByteArray): String {
        return Base64.encodeToString(input, Base64.NO_PADDING or Base64.NO_WRAP)
    }

    private fun decode(input: String): ByteArray {
        return Base64.decode(input, Base64.NO_PADDING or Base64.NO_WRAP)
    }

    @Throws(NoSuchAlgorithmException::class)
    private fun generateAesKeyValue(): String {
        // Do *not* seed secureRandom! Automatically seeded from system entropy
        val random = SecureRandom()
        // Use the largest AES key length which is supported by the OS
        val generator = KeyGenerator.getInstance(transformation)
        try {
            generator.init(256, random)
        } catch (e: Exception) {
            try {
                generator.init(192, random)
            } catch (e1: Exception) {
                generator.init(128, random)
            }

        }

        return encode(generator.generateKey().encoded)
    }


    private fun encrypt(cleartext: String): String {
        try {
            val cipher = Cipher.getInstance(transformation)
            cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(sKey, transformation))
            return encode(cipher.doFinal(cleartext.toByteArray(charset("UTF-8"))))
        } catch (e: Exception) {
            return cleartext
        }
    }


    @SuppressLint("GetInstance")
    private fun decrypt(ciphertext: String): String {

        try {
            val cipher = Cipher.getInstance(transformation)
            cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(sKey, transformation))
            return String(cipher.doFinal(decode(ciphertext)), charset("UTF-8"))
        } catch (e: Exception) {
            return ciphertext
        }

    }

    override fun getAll(): Map<String, String> {
        val encryptedMap = sFile.all
        val decryptedMap = HashMap<String, String>(encryptedMap.size)
        for ((key, value) in encryptedMap) {
            try {
                decryptedMap.put(decrypt(key), decrypt(value.toString()))
            } catch (e: Exception) {
                // Ignore unencrypted key/value pairs
            }
        }
        return decryptedMap
    }


    override fun getString(key: String, defaultValue: String): String {
        val encryptedValue = sFile.getString(encrypt(key), null)
        return if (encryptedValue != null) decrypt(encryptedValue) else defaultValue
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun getStringSet(key: String, defaultValues: Set<String>): Set<String> {
        val encryptedSet = sFile.getStringSet(encrypt(key), null)
                ?: return defaultValues
        val decryptedSet = HashSet<String>(encryptedSet.size)
        for (encryptedValue in encryptedSet) {
            decryptedSet.add(decrypt(encryptedValue))
        }
        return decryptedSet
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        val encryptedValue = sFile.getString(encrypt(key), null)
                ?: return defaultValue
        try {
            return Integer.parseInt(decrypt(encryptedValue))
        } catch (e: NumberFormatException) {
            throw ClassCastException(e.message)
        }

    }

    override fun getLong(key: String, defaultValue: Long): Long {
        val encryptedValue = sFile.getString(encrypt(key), null)
                ?: return defaultValue
        try {
            return java.lang.Long.parseLong(decrypt(encryptedValue))
        } catch (e: NumberFormatException) {
            throw ClassCastException(e.message)
        }

    }

    override fun getFloat(key: String, defaultValue: Float): Float {
        val encryptedValue = sFile.getString(encrypt(key), null)
                ?: return defaultValue
        try {
            return java.lang.Float.parseFloat(decrypt(encryptedValue))
        } catch (e: NumberFormatException) {
            throw ClassCastException(e.message)
        }

    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        val encryptedValue = sFile.getString(encrypt(key), null)
                ?: return defaultValue
        try {
            return java.lang.Boolean.parseBoolean(decrypt(encryptedValue))
        } catch (e: NumberFormatException) {
            throw ClassCastException(e.message)
        }

    }

    override fun contains(key: String): Boolean {
        return sFile.contains(encrypt(key))
    }


    override fun edit(): EncryptedEditor {
        return EncryptedEditor()
    }

    override fun registerOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        sFile.registerOnSharedPreferenceChangeListener(listener)
    }

    override fun unregisterOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        sFile.unregisterOnSharedPreferenceChangeListener(listener)
    }


    /**
     * Wrapper for Android's [SharedPreferences.Editor].
     *
     *
     * Used for modifying values in a [SharedPreferencesEncryption] object. All changes you make in an
     * editor are batched, and not copied back to the original [SharedPreferencesEncryption] until you
     * call [.commit] or [.apply].
     */
    inner class EncryptedEditor : SharedPreferences.Editor {
        private val mEditor: SharedPreferences.Editor

        init {
            mEditor = sFile.edit()
        }

        override fun putString(key: String, value: String): SharedPreferences.Editor {
            mEditor.putString(encrypt(key), encrypt(value))
            return this
        }

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        override fun putStringSet(key: String, values: Set<String>?): SharedPreferences.Editor {
            val encryptedValues = HashSet<String>(values!!.size)
            values.mapTo(encryptedValues) { encrypt(it) }
            mEditor.putStringSet(encrypt(key), encryptedValues)
            return this
        }

        override fun putInt(key: String, value: Int): SharedPreferences.Editor {
            mEditor.putString(encrypt(key),
                    encrypt(Integer.toString(value)))
            return this
        }

        override fun putLong(key: String, value: Long): SharedPreferences.Editor {
            mEditor.putString(encrypt(key),
                    encrypt(java.lang.Long.toString(value)))
            return this
        }

        override fun putFloat(key: String, value: Float): SharedPreferences.Editor {
            mEditor.putString(encrypt(key),
                    encrypt(java.lang.Float.toString(value)))
            return this
        }

        override fun putBoolean(key: String, value: Boolean): SharedPreferences.Editor {
            mEditor.putString(encrypt(key),
                    encrypt(java.lang.Boolean.toString(value)))
            return this
        }

        override fun remove(key: String): SharedPreferences.Editor {
            mEditor.remove(encrypt(key))
            return this
        }

        override fun clear(): SharedPreferences.Editor {
            mEditor.clear()
            return this
        }

        override fun commit(): Boolean {
            return mEditor.commit()
        }

        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        override fun apply() {
            mEditor.apply()
        }
    }
}