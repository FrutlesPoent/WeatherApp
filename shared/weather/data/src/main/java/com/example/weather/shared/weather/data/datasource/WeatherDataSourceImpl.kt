package com.example.weather.shared.weather.data.datasource

import com.example.weather.shared.weather.data.api.WeatherApi
import com.example.weather.shared.weather.data.mapper.toEntity
import com.example.weather.shared.weather.domain.entity.WeatherEntity

class WeatherDataSourceImpl(
	private val api: WeatherApi,
) : WeatherDataSource {

	override suspend fun getCurrentDayWeather(id: Int, appid: String): WeatherEntity =
		api.getCurrentDayWeather(id, appid).toEntity()


}