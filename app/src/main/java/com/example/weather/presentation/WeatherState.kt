package com.example.weather.presentation

import com.example.weather.domain.WeatherType

sealed class WeatherState {

	object Initial : WeatherState()

	object Loading : WeatherState()

	data class Content(val weatherType: WeatherType) : WeatherState()

	data class Error(val errorCode: Int) : WeatherState()
}
