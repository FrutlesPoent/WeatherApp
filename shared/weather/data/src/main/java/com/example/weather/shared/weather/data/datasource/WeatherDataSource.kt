package com.example.weather.shared.weather.data.datasource

import com.example.weather.shared.weather.domain.entity.WeatherEntity

interface WeatherDataSource {

	suspend fun getCurrentDayWeather(id: Int, appid: String): WeatherEntity
}