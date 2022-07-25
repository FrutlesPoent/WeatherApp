package com.example.weather.domain

import androidx.annotation.DrawableRes
import com.example.weather.R

sealed class WeatherType(
	val weatherDescription: String,
	@DrawableRes val iconRes: Int,
) {

	object ClearSky : WeatherType(
		weatherDescription = "Clear Sky",
		R.drawable.ic_sunny,
	)

	object MainlyClear : WeatherType(
		weatherDescription = "Mainly clear",
		iconRes = R.drawable.ic_cloudy
	)

	object PartlyCloudy : WeatherType(
		weatherDescription = "Partly cloudy",
		iconRes = R.drawable.ic_cloudy
	)

	object Overcast : WeatherType(
		weatherDescription = "Overcast",
		iconRes = R.drawable.ic_cloudy
	)

	object Foggy : WeatherType(
		weatherDescription = "Foggy",
		iconRes = R.drawable.ic_very_cloudy
	)

	object DepositingRimeFog : WeatherType(
		weatherDescription = "Depositing rime fog",
		iconRes = R.drawable.ic_very_cloudy
	)

	object LightDrizzle : WeatherType(
		weatherDescription = "Light drizzle",
		iconRes = R.drawable.ic_rainshower
	)

	object ModerateDrizzle : WeatherType(
		weatherDescription = "Moderate drizzle",
		iconRes = R.drawable.ic_rainshower
	)

	object DenseDrizzle : WeatherType(
		weatherDescription = "Dense drizzle",
		iconRes = R.drawable.ic_rainshower
	)

	object LightFreezingDrizzle : WeatherType(
		weatherDescription = "Slight freezing drizzle",
		iconRes = R.drawable.ic_snowyrainy
	)

	object DenseFreezingDrizzle : WeatherType(
		weatherDescription = "Dense freezing drizzle",
		iconRes = R.drawable.ic_snowyrainy
	)

	object SlightRain : WeatherType(
		weatherDescription = "Slight rain",
		iconRes = R.drawable.ic_rainy
	)

	object ModerateRain : WeatherType(
		weatherDescription = "Rainy",
		iconRes = R.drawable.ic_rainy
	)

	object HeavyRain : WeatherType(
		weatherDescription = "Heavy rain",
		iconRes = R.drawable.ic_rainy
	)

	object HeavyFreezingRain : WeatherType(
		weatherDescription = "Heavy freezing rain",
		iconRes = R.drawable.ic_snowyrainy
	)

	object SlightSnowFall : WeatherType(
		weatherDescription = "Slight snow fall",
		iconRes = R.drawable.ic_snowy
	)

	object ModerateSnowFall : WeatherType(
		weatherDescription = "Moderate snow fall",
		iconRes = R.drawable.ic_heavysnow
	)

	object HeavySnowFall : WeatherType(
		weatherDescription = "Heavy snow fall",
		iconRes = R.drawable.ic_heavysnow
	)

	object SnowGrains : WeatherType(
		weatherDescription = "Snow grains",
		iconRes = R.drawable.ic_heavysnow
	)

	object SlightRainShowers : WeatherType(
		weatherDescription = "Slight rain showers",
		iconRes = R.drawable.ic_rainshower
	)

	object ModerateRainShowers : WeatherType(
		weatherDescription = "Moderate rain showers",
		iconRes = R.drawable.ic_rainshower
	)

	object ViolentRainShowers : WeatherType(
		weatherDescription = "Violent rain showers",
		iconRes = R.drawable.ic_rainshower
	)

	object SlightSnowShowers : WeatherType(
		weatherDescription = "Light snow showers",
		iconRes = R.drawable.ic_snowy
	)

	object HeavySnowShowers : WeatherType(
		weatherDescription = "Heavy snow showers",
		iconRes = R.drawable.ic_snowy
	)

	object ModerateThunderstorm : WeatherType(
		weatherDescription = "Moderate thunderstorm",
		iconRes = R.drawable.ic_thunder
	)

	object SlightHailThunderstorm : WeatherType(
		weatherDescription = "Thunderstorm with slight hail",
		iconRes = R.drawable.ic_rainythunder
	)

	object HeavyHailThunderstorm : WeatherType(
		weatherDescription = "Thunderstorm with heavy hail",
		iconRes = R.drawable.ic_rainythunder
	)
}
