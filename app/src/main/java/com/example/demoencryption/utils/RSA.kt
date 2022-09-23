package com.example.demoencryption.utils

import com.example.demoencryption.toByteArray
import java.security.*
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher


class RSA {

    companion object {
         var publicKey: PublicKey
         var privateKey: PrivateKey

        init {
            val keyGen = KeyPairGenerator.getInstance("RSA")
            keyGen.initialize(1024)
            val pair = keyGen.generateKeyPair()
            privateKey = pair.private
            publicKey = pair.public
        }

        // Encrypt using publickey
        fun encryptMessage(plainText: String): String {
            val publicKey_str: String = Base64.getEncoder().encodeToString(publicKey.encoded)
            val cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
            cipher.init(Cipher.ENCRYPT_MODE, loadPublicKey(publicKey_str))
            return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.toByteArray()))
        }

        fun loadPublicKey(stored: String): Key {
            val data: ByteArray = Base64.getDecoder().
            decode(stored.toByteArray())
            val spec = X509EncodedKeySpec(data)
            val fact = KeyFactory.getInstance("RSA")
            return fact.generatePublic(spec)
        }
    }
}