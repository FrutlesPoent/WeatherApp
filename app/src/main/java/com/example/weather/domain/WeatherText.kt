package com.example.weather.domain

import java.util.Date

data class WeatherText(
	val cityName: String,
	val countryCode: String,
	val temperature: String,
	val iconUrl: String,
	val lastUpdated: Date,
	val humidity: String,
	val pressure: String,
	val desc: String,
)