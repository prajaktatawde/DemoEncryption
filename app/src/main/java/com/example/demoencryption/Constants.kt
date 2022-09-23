package com.example.demoencryption

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets


inline fun String.toCharArray(): CharArray = (this as java.lang.String).toCharArray()
inline fun String(bytes: ByteArray): String = java.lang.String(bytes,StandardCharsets.UTF_8) as String

inline fun String.toByteArray(charset: Charset = StandardCharsets.UTF_8): ByteArray = (this as java.lang.String).getBytes(charset)