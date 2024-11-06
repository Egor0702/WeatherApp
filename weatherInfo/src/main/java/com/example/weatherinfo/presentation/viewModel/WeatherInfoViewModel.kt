package com.example.weatherinfo.presentation.viewModel

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.core.presentation.viewModel.BaseViewModel
import com.example.core.utils.DataHolder
import com.example.core.utils.toDataHolder
import com.example.weatherinfo.presentation.view.useCase.CurrentWeatherInfoUseCase
import com.example.weatherinfo.presentation.view.useCase.GetForecastUseCase
import com.example.weatherinfo_api.data.request.CurrentWeatherInfoRequest
import com.example.weatherinfo_api.data.request.ForecastRequest
import com.example.weatherinfo_api.data.responses.CurrentWeatherInfo
import com.example.weatherinfo_api.data.responses.ForecastInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * ViewModel for fragment which showing weather info
 *
 * @property currentWeatherInfoUseCase [CurrentWeatherInfoUseCase]
 * @property getForecastUseCase [CurrentWeatherInfoUseCase]
 *
 * @property _currentWeatherInfoState State for current weather info
 * @property currentWeatherInfoState getter for [_currentWeatherInfoState]
 * @property _forecastInfoState State for forecast info
 * @property forecastInfoState getter for [_forecastInfoState]
 */
class WeatherInfoViewModel @Inject constructor(
    private val currentWeatherInfoUseCase: CurrentWeatherInfoUseCase,
    private val getForecastUseCase: GetForecastUseCase
): BaseViewModel() {

    private val _currentWeatherInfoState: MutableStateFlow<DataHolder<CurrentWeatherInfo>?> = MutableStateFlow(null)
    val currentWeatherInfoState = _currentWeatherInfoState.asStateFlow()

    private val _forecastInfoState: MutableStateFlow<DataHolder<ForecastInfo>?> = MutableStateFlow(null)
    val forecastInfoState = _forecastInfoState.filterNotNull()

    private val city = "New York"
    private val units = "metric"
    private val days = 3

    override fun init(args: Bundle) {
        super.init(args)
        Log.d("Egor", "init")

        getCurrentWeatherInfo()
        getForecastInfo()
    }
    private fun getCurrentWeatherInfo(){
        Log.d("Egor", "getCurrentWeatherInfo()")
        viewModelScope.launch {
            Timber.tag("Egor").d("getCurrentWeatherInfo()  viewModelScope.launch {")
            _currentWeatherInfoState.value = currentWeatherInfoUseCase(
                CurrentWeatherInfoRequest(
                    city = city,
                    units = units
                )
            ).toDataHolder()
            Timber.tag("Egor").d("getCurrentWeatherInfo()  viewModelScope.launch { res =${_currentWeatherInfoState.value}")
        }
    }

    private fun getForecastInfo() {
        viewModelScope.launch {
            _forecastInfoState.value = getForecastUseCase(
                ForecastRequest(
                    city = city,
                    units = units
                )
            ).toDataHolder()
        }
    }
}