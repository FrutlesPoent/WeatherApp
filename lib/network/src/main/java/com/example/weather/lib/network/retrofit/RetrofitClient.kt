package com.example.weather.lib.network.retrofit

import com.example.weather.lib.network.interceptor.AuthInterceptor
import com.example.weather.lib.network.utils.ResponseHandler
import com.example.weather.shared.weather.data.api.WeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
	factory { AuthInterceptor() }
	factory { provideOkHttpClient(get(), get()) }
	factory { provideForecastApi(get()) }
	factory { provideLoggingInterceptor() }
	single { provideRetrofit(get()) }
	factory { ResponseHandler() }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
	return Retrofit.Builder().baseUrl("https://api.openweathermap.org").client(okHttpClient)
		.addConverterFactory(MoshiConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
	OkHttpClient()
		.newBuilder()
		.addInterceptor(authInterceptor)
		.addInterceptor(loggingInterceptor)
		.build()

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
	val logger = HttpLoggingInterceptor()
	logger.level = HttpLoggingInterceptor.Level.BASIC
	return logger
}

fun provideForecastApi(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)