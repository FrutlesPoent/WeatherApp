package com.example.weather

import android.app.Application
import com.example.weather.di.ViewModule
import com.example.weather.shared.weather.data.di.WeatherDataModule
import com.example.weather.shared.weather.domain.di.WeatherDomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@App)
			androidLogger(Level.ERROR)
			modules(ViewModule)
			modules(WeatherDataModule + WeatherDomainModule)
		}
	}
}