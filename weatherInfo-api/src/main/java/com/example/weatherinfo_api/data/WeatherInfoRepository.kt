package com.example.weatherinfo_api.data

import com.example.weatherinfo_api.data.request.CurrentWeatherInfoRequest
import com.example.weatherinfo_api.data.request.ForecastRequest
import com.example.weatherinfo_api.data.responses.CurrentWeatherInfo
import com.example.weatherinfo_api.data.responses.ForecastInfo

/**
 * Repository for receiving weather data
 */
interface WeatherInfoRepository {

    /**
     * Getting weather data
     *
     * @return [CurrentWeatherInfo]
     */
    suspend fun getCurrentWeather(weatherInfoRequest: CurrentWeatherInfoRequest): CurrentWeatherInfo

    /**
     * Getting the weather forecast
     *
     * @return [ForecastRequest]
     */
    suspend fun getForecast(forecastRequest: ForecastRequest): ForecastInfo
}