package com.example.weather.shared.weather.domain.entity

data class SysEntity(
	val type: Int,
	val id: Int,
	val country: String,
	val sunrise: Int,
	val sunset: Int,
)
