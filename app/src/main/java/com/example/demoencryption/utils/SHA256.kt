package com.example.demoencryption.utils

import com.example.demoencryption.toByteArray
import java.security.MessageDigest

class SHA256 {

    companion object{
        fun hash_value(value:String):String {
            val digest = MessageDigest.getInstance("SHA-256")
            val encodedhash = digest.digest(value.toByteArray())
            val shaHex_value = bytesToHex(encodedhash)

            return shaHex_value
        }

        private fun bytesToHex(hash: ByteArray): String {
            val hexString = StringBuilder(2 * hash.size)
            for (i in 0..hash.size - 1) {
                val hex = Integer.toHexString(0xff and hash[i].toInt())
                if (hex.length == 1) {
                    hexString.append('0')
                }
                hexString.append(hex)
            }
            return hexString.toString()
        }
    }
}