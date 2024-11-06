package com.example.weatherapp.navigation

import com.example.core.navigation.MainRouter
import com.example.weatherinfo.navigation.WeatherInfoScreen
import javax.inject.Inject

class StartupCoordinator @Inject constructor(
    private val mainRouter: MainRouter
) {

    /**
     *  Show weather info screen
     */
    fun showWeatherInfoScreen() {
        mainRouter.newRootScreen(WeatherInfoScreen.WeatherInfoMainScreen())
    }
}