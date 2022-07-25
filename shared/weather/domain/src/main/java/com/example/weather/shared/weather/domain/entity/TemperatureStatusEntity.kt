package com.example.weather.shared.weather.domain.entity

data class TemperatureStatusEntity(
	val temp: Float,
	val feels: Float,
	val tempMin: Float,
	val tempMax: Float,
	val pressure: Int,
	val humidity: Int,
)
