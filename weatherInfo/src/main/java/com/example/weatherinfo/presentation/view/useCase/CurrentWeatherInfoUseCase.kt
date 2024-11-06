package com.example.weatherinfo.presentation.view.useCase

import com.example.core.di.IoDispatcher
import com.example.core.useCase.BaseUseCase
import com.example.weatherinfo_api.data.WeatherInfoRepository
import com.example.weatherinfo_api.data.request.CurrentWeatherInfoRequest
import com.example.weatherinfo_api.data.responses.CurrentWeatherInfo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Use case for getting current weather info
 *
 * @property dispatcher The Use Case will be executed on this dispatcher
 *
 */
class CurrentWeatherInfoUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val weatherInfoRepository: WeatherInfoRepository
): BaseUseCase<CurrentWeatherInfoRequest, CurrentWeatherInfo>(dispatcher) {

    /**
     * see [BaseUseCase.execute]
     *
     * @param param [CurrentWeatherInfoRequest]
     *
     */
    override suspend fun execute(param: CurrentWeatherInfoRequest): CurrentWeatherInfo {
        return weatherInfoRepository.getCurrentWeather(param)
    }
}