package com.example.weather.shared.weather.data.mapper

import com.example.weather.shared.weather.data.dto.CityWeatherInfoDto
import com.example.weather.shared.weather.data.dto.CloudDto
import com.example.weather.shared.weather.data.dto.CoordDto
import com.example.weather.shared.weather.data.dto.SysDto
import com.example.weather.shared.weather.data.dto.TemperatureStatusDto
import com.example.weather.shared.weather.data.dto.WindDto
import com.example.weather.shared.weather.domain.entity.CityWeatherInfoEntity
import com.example.weather.shared.weather.domain.entity.CloudEntity
import com.example.weather.shared.weather.domain.entity.CoordEntity
import com.example.weather.shared.weather.domain.entity.SysEntity
import com.example.weather.shared.weather.domain.entity.TemperatureStatusEntity
import com.example.weather.shared.weather.domain.entity.WeatherEntity
import com.example.weather.shared.weather.domain.entity.WindEntity
import com.example.weather.shared.weather.data.dto.WeatherDto

fun WeatherDto.toEntity() = WeatherEntity(
	coord = coord.toEntity(),
	weather = weather.toEntity(),
	base = base,
	temperatureStats = temperatureStats.toEntity(),
	visibility = visibility,
	wind = wind.toEntity(),
	cloud = cloud.toEntity(),
	dt = dt,
	sys = sys.toEntity(),
	timezone = timezone,
	id = id,
	cityName = cityName,
	cod = cod,
)

fun CoordDto.toEntity() = CoordEntity(
	lat = lat,
	long = lon,
)

fun List<CityWeatherInfoDto>.toEntity() = map(CityWeatherInfoDto::toEntity)

fun CityWeatherInfoDto.toEntity() = CityWeatherInfoEntity(
	id = id,
	main = main,
	description = description,
	icon = icon,
)

fun TemperatureStatusDto.toEntity() = TemperatureStatusEntity(
	temp = temp,
	feels = feels,
	tempMin = tempMin,
	tempMax = tempMax,
	pressure = pressure,
	humidity = humidity,
)

fun WindDto.toEntity() = WindEntity(
	speed = speed,
	deg = deg,
)

fun CloudDto.toEntity() = CloudEntity(
	all = all,
)

fun SysDto.toEntity() = SysEntity(
	type = type,
	id = id,
	country = country,
	sunrise = sunrise,
	sunset = sunset,
)