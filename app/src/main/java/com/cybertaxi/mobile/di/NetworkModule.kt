package com.cybertaxi.mobile.di

import android.content.Context
import com.cybertaxi.mobile.data.UserPreferences
import com.cybertaxi.mobile.data.network.HeaderInterceptor
import com.cybertaxi.mobile.data.network.trips.TripVariantsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://cybertaxi-server.com"

    @Provides
    @Singleton
    fun provideInterceptor(userPreferences: UserPreferences): HeaderInterceptor {
        return HeaderInterceptor(userPreferences)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HeaderInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor)
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun retrofit(@ApplicationContext context: Context, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideTripVariantsApi(retrofit: Retrofit): TripVariantsApi {
        return retrofit.create(TripVariantsApi::class.java)
    }
}