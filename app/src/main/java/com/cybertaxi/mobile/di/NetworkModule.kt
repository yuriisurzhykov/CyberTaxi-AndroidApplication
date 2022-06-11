package com.cybertaxi.mobile.di

import android.content.Context
import com.cybertaxi.mobile.data.UserPreferences
import com.cybertaxi.mobile.data.network.HeaderInterceptor
import com.cybertaxi.mobile.data.network.countries.CountriesApi
import com.cybertaxi.mobile.data.network.messaging.PushTokenApi
import com.cybertaxi.mobile.data.network.trips.TripsCancellationApi
import com.cybertaxi.mobile.data.network.trips.TripsVariantsApi
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

    private const val BASE_HTTP_URL = "http://cybertaxi-server.com"
    private const val BASE_WSS_URL = "ws://cybertaxi-server.com"

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
            .baseUrl(BASE_HTTP_URL)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideTripVariantsApi(retrofit: Retrofit): TripsVariantsApi {
        return retrofit.create(TripsVariantsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTripCancellationApi(retrofit: Retrofit): TripsCancellationApi {
        return retrofit.create(TripsCancellationApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCountriesApi(retrofit: Retrofit): CountriesApi {
        return retrofit.create(CountriesApi::class.java)
    }

    @Provides
    @Singleton
    fun providePushTokenApi(retrofit: Retrofit): PushTokenApi {
        return retrofit.create(PushTokenApi::class.java)
    }
}