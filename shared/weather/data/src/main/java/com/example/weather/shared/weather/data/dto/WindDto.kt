package com.example.weather.shared.weather.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindDto(
	@Json(name = "speed") val speed: Int,
	@Json(name = "deg") val deg: Int,
)
