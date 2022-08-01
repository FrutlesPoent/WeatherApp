package com.example.weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.domain.WeatherText
import com.example.weather.shared.weather.domain.usecase.GetCurrentWeatherUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date
import java.util.Locale

class MainViewModel(
	private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
) : ViewModel() {

	private companion object {

		const val NOVOSIBIRSK = 1496747
		const val APPID = "YOUR TOKEN"
		const val URL_START = "https://openweathermap.org/img/wn/"
		const val URL_END = "@2x.png"
	}

	private val _stateFlow = MutableStateFlow<WeatherState>(WeatherState.Initial)
	val stateFlow: Flow<WeatherState>
		get() = _stateFlow.asStateFlow()

	private val fetchErrorHandler = CoroutineExceptionHandler { _, _ ->
		_stateFlow.value = WeatherState.Error
	}

	fun fetchCurrentWeather() {
		viewModelScope.launch(fetchErrorHandler) {
			_stateFlow.value = WeatherState.Loading
			val weatherEntity = getCurrentWeatherUseCase(NOVOSIBIRSK, APPID)
			val iconUrl = URL_START + weatherEntity.weather[0].icon + URL_END
			val weatherText = WeatherText(
				cityName = weatherEntity.cityName,
				countryCode = weatherEntity.sys.country,
				temperature = kelvinToCelsius(weatherEntity.temperatureStats.temp).toString() + " ℃",
				iconUrl = iconUrl,
				lastUpdated = getLastUpdate(weatherEntity.dt),
				desc = weatherEntity.weather[0].description.uppercase(Locale.US),
				pressure = weatherEntity.temperatureStats.humidity.toString() + " %",
				humidity = weatherEntity.temperatureStats.pressure.toString() + " hPa",
			)
			_stateFlow.value = WeatherState.Content(weatherText)
		}
	}

	private fun kelvinToCelsius(temp: Float): Float {
		val celsius = temp - 273.15
		return String.format("%.2f", celsius).toFloat()
	}

	private fun getLastUpdate(date: Long): Date =
		Date(date * 1000)
}