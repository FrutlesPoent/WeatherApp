package com.example.weather.shared.weather.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TemperatureStatusDto(
	@Json(name = "temp") val temp: Float,
	@Json(name = "feels_like") val feels: Float,
	@Json(name = "temp_min") val tempMin: Float,
	@Json(name = "temp_max") val tempMax: Float,
	@Json(name = "pressure") val pressure: Int,
	@Json(name = "humidity") val humidity: Int,
)
