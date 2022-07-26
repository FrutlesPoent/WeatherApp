package com.example.weather.lib.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		var req = chain.request()
		// DONT INCLUDE API KEYS IN YOUR SOURCE CODE
		// Edit (or add) a gradle.properties file in your project root
		// and add the API_KEY there!
		val url = req.url.newBuilder().addQueryParameter("APPID", "https://api.openweathermap.org").build()
		req = req.newBuilder().url(url).build()
		return chain.proceed(req)
	}
}