package com.example.weather.shared.weather.domain.di

import com.example.weather.shared.weather.domain.usecase.GetCurrentWeatherUseCase
import org.koin.dsl.module

val WeatherDomainModule = module {
	factory { GetCurrentWeatherUseCase(get()) }
}