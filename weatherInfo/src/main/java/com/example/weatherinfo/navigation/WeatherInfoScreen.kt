package com.example.weatherinfo.navigation

import androidx.fragment.app.Fragment
import com.example.core.navigation.BaseScreen
import com.example.weatherinfo.presentation.view.WeatherInfoFragment

/**
 * Class for making DTO for navigation
 */
class WeatherInfoScreen {

    /**
     * Class for showing main weather information
     */
    class WeatherInfoMainScreen : BaseScreen(){
        override fun getFragmentInstance(): Fragment = WeatherInfoFragment()

    }
}