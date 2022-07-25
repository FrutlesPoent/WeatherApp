package com.example.weather.di

import com.example.weather.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModule = module {
	viewModel {
		MainViewModel(
			getCurrentWeatherUseCase = get(),
		)
	}
}