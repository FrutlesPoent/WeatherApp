package com.example.weather.shared.weather.domain.repository

import com.example.weather.shared.weather.domain.entity.WeatherEntity

interface WeatherRepository {

	suspend fun getCurrentDayWeather(id: Int, appid: String): WeatherEntity
}