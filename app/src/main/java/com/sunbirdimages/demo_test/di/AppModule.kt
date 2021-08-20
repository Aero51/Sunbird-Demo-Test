package com.sunbirdimages.demo_test.di

import android.app.Application
import androidx.room.Room
import com.sunbirdimages.demo_test.api.AstrologyApi
import com.sunbirdimages.demo_test.data.AstrologyDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { provideRetrofit() }
    single { provideAstrologyApi(get()) }
    single { provideDatabase(get()) }


}


fun provideRetrofit(): Retrofit {

    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    return Retrofit.Builder()
        .baseUrl(AstrologyApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}


fun provideAstrologyApi(retrofit: Retrofit): AstrologyApi =
    retrofit.create(AstrologyApi::class.java)


fun provideDatabase(app: Application): AstrologyDatabase =
    Room.databaseBuilder(app, AstrologyDatabase::class.java, "astrology_database")
        .build()
