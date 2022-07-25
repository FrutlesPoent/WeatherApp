package com.example.weather.shared.weather.data.repository

import com.example.weather.shared.weather.data.datasource.WeatherDataSource
import com.example.weather.shared.weather.domain.entity.WeatherEntity
import com.example.weather.shared.weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
	private val dataSource: WeatherDataSource,
) : WeatherRepository {

	override suspend fun getCurrentDayWeather(id: Int, appid: String): WeatherEntity =
		dataSource.getCurrentDayWeather(id, appid)
}