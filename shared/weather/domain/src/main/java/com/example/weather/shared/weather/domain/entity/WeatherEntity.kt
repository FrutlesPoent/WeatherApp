package com.example.weather.shared.weather.domain.entity

data class WeatherEntity(
	val coord: CoordEntity,
	val weather: List<CityWeatherInfoEntity>,
	val base: String,
	val temperatureStats: TemperatureStatusEntity,
	val visibility: Int,
	val wind: WindEntity,
	val cloud: CloudEntity,
	val dt: Long,
	val sys: SysEntity,
	val timezone: Int,
	val id: Int,
	val cityName: String,
	val cod: Int,
)
