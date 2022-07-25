package com.example.weather.shared.weather.data.di

import com.example.weather.shared.weather.data.api.WeatherApi
import com.example.weather.shared.weather.data.datasource.WeatherDataSource
import com.example.weather.shared.weather.data.datasource.WeatherDataSourceImpl
import com.example.weather.shared.weather.data.repository.WeatherRepositoryImpl
import com.example.weather.shared.weather.domain.repository.WeatherRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val WeatherApiModule = module {
	factory {
		Retrofit.Builder()
			.baseUrl("https://api.openweathermap.org")
			.addConverterFactory(MoshiConverterFactory.create(moshi))
			.build()
			.create(WeatherApi::class.java)
	}
}

internal val WeatherDataSourceModule = module {
	single<WeatherDataSource> { WeatherDataSourceImpl(get()) }
}

internal val WeatherRepositoryModule = module {
	single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}

val WeatherDataModule = listOf(
	WeatherApiModule,
	WeatherDataSourceModule,
	WeatherRepositoryModule,
)

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
