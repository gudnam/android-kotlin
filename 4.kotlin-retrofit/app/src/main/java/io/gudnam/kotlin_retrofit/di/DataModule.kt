package io.gudnam.kotlin_retrofit.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_retrofit.BuildConfig
import io.gudnam.kotlin_retrofit.R
import io.gudnam.kotlin_retrofit.data.api.APIRequestInterceptor
import io.gudnam.kotlin_retrofit.data.api.APIService
import io.gudnam.kotlin_retrofit.di.qualifier.APIAccessToken
import io.gudnam.kotlin_retrofit.di.qualifier.ApplicationQualifier
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by gudnam on 2017. 5. 11..
 */
@Module
class DataModule {

    @Provides @Singleton @APIAccessToken
    fun provideApiKey(@ApplicationQualifier context: Context): String = context.getString(R.string.access_token)

    @Provides @Singleton
    fun provideOkHttpClient(interceptor: APIRequestInterceptor): OkHttpClient =
            OkHttpClient().newBuilder()
                    .addInterceptor(interceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                    })
                    .build()

    @Provides @Singleton
    fun provideRequestInterceptor(@APIAccessToken apiAccessToken: String)
            = APIRequestInterceptor(apiAccessToken)

    @Provides @Singleton
    fun provideRestAdapter(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://io-switcher-dev.switcher.kr/v3/mobile/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides @Singleton
    fun providesAPIService(retrofit: Retrofit): APIService = retrofit.create(APIService::class.java)
}