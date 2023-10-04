package com.mahle.smartbikesystems.core.api

import com.mahle.smartbikesystems.BuildConfig
import com.mahle.smartbikesystems.core.utils.Common.getUrlsBase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    fun build(): Retrofit =
        Retrofit.Builder()
            .client(getHttpClient())
            .baseUrl(getUrlsBase())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun getHttpClient(): OkHttpClient {
        val timeout = 45000L
        return OkHttpClient.Builder()
            .connectTimeout(timeout, TimeUnit.MILLISECONDS)
            .writeTimeout(timeout, TimeUnit.MILLISECONDS)
            .readTimeout(timeout, TimeUnit.MILLISECONDS)
            .addInterceptor(getLoggingInterceptor())
            .build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return interceptor
    }
}