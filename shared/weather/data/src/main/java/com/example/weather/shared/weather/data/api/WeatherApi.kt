package com.example.weather.shared.weather.data.api

import com.example.weather.shared.weather.data.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

	@GET("/data/2.5/weather")
	suspend fun getCurrentDayWeather(@Query("id") id: Int, @Query("appid") appid: String): WeatherDto

}