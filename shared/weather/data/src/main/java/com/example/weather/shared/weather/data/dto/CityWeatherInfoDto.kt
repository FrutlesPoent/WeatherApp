package com.example.weather.shared.weather.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityWeatherInfoDto(
	@Json(name = "id") val id: Int,
	@Json(name = "main") val main: String,
	@Json(name = "description") val description: String,
	@Json(name = "icon") val icon: String,
)
