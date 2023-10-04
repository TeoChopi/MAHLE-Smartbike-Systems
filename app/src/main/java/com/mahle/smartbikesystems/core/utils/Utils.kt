package com.mahle.smartbikesystems.core.utils

import com.mahle.smartbikesystems.BuildConfig
import kotlinx.datetime.Clock
import java.math.BigInteger
import java.security.MessageDigest

object Common {

    fun getTimeStamp(): String {
        return Clock.System.now().toEpochMilliseconds().toString()
    }

    fun getPublicApiKey(): String {
        return BuildConfig.PUBLIC_KEY
    }

    fun getPrivateApiKey(): String {
        return BuildConfig.PRIVATE_KEY
    }

    fun getUrlsBase(): String {
        return BuildConfig.URL_BASE
    }

    fun getHash(input: String = getTimeStamp() + getPrivateApiKey() + getPublicApiKey()): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}