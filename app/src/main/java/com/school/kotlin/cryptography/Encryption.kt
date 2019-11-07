package com.school.kotlin.cryptography

import java.io.*
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import javax.crypto.*
import javax.crypto.spec.SecretKeySpec

/**
 * Created by android on 18/12/17.
 */
class Encryption {
    private val key = "MyDifficultPassw".toByteArray()
    private val transformation = "AES/ECB/PKCS5Padding"

    @Throws(IOException::class, NoSuchAlgorithmException::class, NoSuchPaddingException::class, InvalidKeyException::class)
    fun encrypt(`object`: Serializable, ostream: OutputStream) {
        try {
            // Length is 16 byte
            val sks = SecretKeySpec(key, transformation)

            // Create cipher
            val cipher = Cipher.getInstance(transformation)
            cipher.init(Cipher.ENCRYPT_MODE, sks)
            val sealedObject = SealedObject(`object`, cipher)

            // Wrap the output stream
            val cos = CipherOutputStream(ostream, cipher)
            val outputStream = ObjectOutputStream(cos)
            outputStream.writeObject(sealedObject)
            outputStream.close()
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
        }

    }

    @Throws(IOException::class, NoSuchAlgorithmException::class, NoSuchPaddingException::class, InvalidKeyException::class)
    fun decrypt(istream: InputStream): Any? {
        val sks = SecretKeySpec(key, transformation)
        val cipher = Cipher.getInstance(transformation)
        cipher.init(Cipher.DECRYPT_MODE, sks)

        val cipherInputStream = CipherInputStream(istream, cipher)
        val inputStream = ObjectInputStream(cipherInputStream)
        val sealedObject: SealedObject
        try {
            sealedObject = inputStream.readObject() as SealedObject
            return sealedObject.getObject(cipher)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            return null
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
            return null
        } catch (e: BadPaddingException) {
            e.printStackTrace()
            return null
        }

    }
}