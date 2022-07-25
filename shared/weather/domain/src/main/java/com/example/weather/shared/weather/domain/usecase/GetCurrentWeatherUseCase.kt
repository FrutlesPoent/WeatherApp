package com.example.weather.shared.weather.domain.usecase

import com.example.weather.shared.weather.domain.entity.WeatherEntity
import com.example.weather.shared.weather.domain.repository.WeatherRepository

class GetCurrentWeatherUseCase(
	private val repository: WeatherRepository,
) {

	suspend operator fun invoke(id: Int, appid: String): WeatherEntity =
		repository.getCurrentDayWeather(id, appid)
}