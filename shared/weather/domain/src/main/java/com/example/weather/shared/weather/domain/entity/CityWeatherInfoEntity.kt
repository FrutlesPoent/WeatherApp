package com.example.weather.shared.weather.domain.entity

data class CityWeatherInfoEntity(
	val id: Int,
	val main: String,
	val description: String,
	val icon: String,
)
