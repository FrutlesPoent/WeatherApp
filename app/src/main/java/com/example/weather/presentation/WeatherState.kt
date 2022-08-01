package com.example.weather.presentation

import com.example.weather.domain.WeatherText

sealed class WeatherState {

	object Initial : WeatherState()

	object Loading : WeatherState()

	data class Content(val weatherContent: WeatherText) : WeatherState()

	object Error : WeatherState()
}
