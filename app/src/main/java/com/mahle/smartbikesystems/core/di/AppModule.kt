package com.mahle.smartbikesystems.core.di

import com.mahle.smartbikesystems.core.api.ApiService
import com.mahle.smartbikesystems.core.api.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providerApiServiceClient(): ApiService =
        RetrofitBuilder.build().create(ApiService::class.java)
}