package com.example.weatherinfo_api.data

import com.example.weatherinfo_api.data.request.CurrentWeatherInfoRequest
import com.example.weatherinfo_api.data.request.ForecastRequest
import com.example.weatherinfo_api.data.responses.CurrentWeatherInfo
import com.example.weatherinfo_api.data.responses.ForecastInfo
import javax.inject.Inject

/**
 * Implementation of [WeatherInfoRepository]
 */
class WeatherInfoRepositoryImpl @Inject constructor(
    private val weatherApiService: WeatherApiService
): WeatherInfoRepository {
    override suspend fun getCurrentWeather(weatherInfoRequest: CurrentWeatherInfoRequest): CurrentWeatherInfo {
        return weatherApiService.getCurrentWeather(city = weatherInfoRequest.city, units = weatherInfoRequest.units)
    }

    override suspend fun getForecast(forecastRequest: ForecastRequest): ForecastInfo {
        return weatherApiService.getSevenDayForecast(city = forecastRequest.city, units = forecastRequest.units)
    }
}