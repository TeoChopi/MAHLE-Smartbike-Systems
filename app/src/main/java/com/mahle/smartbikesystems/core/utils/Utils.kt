package com.mahle.smartbikesystems.core.utils

import com.mahle.smartbikesystems.BuildConfig
import com.mahle.smartbikesystems.core.extensions.toMD5
import kotlinx.datetime.Clock

object Common {

    fun getTimeStamp(): String {
        return Clock.System.now().toEpochMilliseconds().toString()
    }

    fun getPublicApiKey(): String {
        return BuildConfig.PUBLIC_KEY
    }

    private fun getPrivateApiKey(): String {
        return BuildConfig.PRIVATE_KEY
    }

    fun getUrlsBase(): String {
        return BuildConfig.URL_BASE
    }

    fun calculateHash() = "${getTimeStamp()}${getPrivateApiKey()}${getPublicApiKey()}".toMD5()
}