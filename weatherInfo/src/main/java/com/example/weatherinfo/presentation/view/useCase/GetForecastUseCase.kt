package com.example.weatherinfo.presentation.view.useCase

import com.example.core.di.IoDispatcher
import com.example.core.useCase.BaseUseCase
import com.example.weatherinfo_api.data.WeatherInfoRepository
import com.example.weatherinfo_api.data.request.ForecastRequest
import com.example.weatherinfo_api.data.responses.ForecastInfo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Use case for getting forecast
 *
 * @property dispatcher The Use Case will be executed on this dispatcher
 *
 */
class GetForecastUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val weatherInfoRepository: WeatherInfoRepository
): BaseUseCase<ForecastRequest, ForecastInfo>(dispatcher) {

    /**
     * see [BaseUseCase.execute]
     *
     * @param param [ForecastInfo]
     *
     */
    override suspend fun execute(param: ForecastRequest): ForecastInfo {
        return weatherInfoRepository.getForecast(param)
    }
}