package com.example.weather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.weather.databinding.MainFragmentBinding
import com.example.weather.lib.binding.BindingFragment
import com.example.weather.lib.binding.launchWhenResumed
import com.example.weather.presentation.MainViewModel
import com.example.weather.presentation.WeatherState
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.system.exitProcess

class MainFragment : BindingFragment<MainFragmentBinding>() {

	private val viewModel: MainViewModel by viewModel()

	override fun binding(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?,
	) = MainFragmentBinding.inflate(inflater, container, false)

	override fun otherSetups() {
		super.otherSetups()
		bindUi(viewModel.stateFlow)
		bindSystemButton()
		viewModel.fetchCurrentWeather()
	}

	private fun bindUi(state: Flow<WeatherState>) {
		state.onEach(::renderUi).launchWhenResumed(viewLifecycleOwner.lifecycleScope)
	}

	private fun renderUi(state: WeatherState) {
		when (state) {
			is WeatherState.Content -> renderContent(state)
			is WeatherState.Error   -> renderError()

			else                    -> {}
		}
	}

	private fun renderContent(state: WeatherState.Content) {
		binding.mainScreen.isVisible = true
		binding.errorMessage.isVisible = false

		state.weatherContent.let {
			binding.cityName.text = it.cityName
			binding.updatedField.text = it.lastUpdated.toString()
			binding.currentTemperatureField.text = it.temperature
			binding.detailsField.text = it.desc + "\n" + "Pressure: " + it.pressure + "\n" + "Humidity: " + it.humidity
			Picasso.get().load(it.iconUrl).resize(500, 500).centerCrop().into(binding.weatherIcon)
		}

	}

	private fun renderError() {
		binding.mainScreen.isVisible = true
		binding.errorMessage.isVisible = true
		binding.errorMessage.text = "Произошла ошибка"
	}

	private fun bindSystemButton() {
		requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) { exitProcess(0) }
	}
}