package com.example.weather.shared.weather.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDto(
	@Json(name = "coord") val coord: CoordDto,
	@Json(name = "weather") val weather: List<CityWeatherInfoDto>,
	@Json(name = "base") val base: String,
	@Json(name = "main") val temperatureStats: TemperatureStatusDto,
	@Json(name = "visibility") val visibility: Int,
	@Json(name = "wind") val wind: WindDto,
	@Json(name = "clouds") val cloud: CloudDto,
	@Json(name = "dt") val dt: Long,
	@Json(name = "sys") val sys: SysDto,
	@Json(name = "timezone") val timezone: Int,
	@Json(name = "id") val id: Int,
	@Json(name = "name") val cityName: String,
	@Json(name = "cod") val cod: Int,
)