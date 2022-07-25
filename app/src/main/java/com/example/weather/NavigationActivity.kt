package com.example.weather

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

class NavigationActivity : AppCompatActivity(R.layout.activity_main) {

	override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
		super.onCreate(savedInstanceState)
		val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_graph) as NavHostFragment
		val navController = navHostFragment.navController
	}
}