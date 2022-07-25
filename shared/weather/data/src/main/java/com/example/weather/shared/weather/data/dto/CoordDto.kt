package com.example.weather.shared.weather.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoordDto(
	@Json(name = "lon") val lon: Float,
	@Json(name = "lat") val lat: Float,
)
