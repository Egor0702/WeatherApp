package com.example.weatherinfo_api.data

import com.example.weatherinfo_api.data.responses.CurrentWeatherInfo
import com.example.weatherinfo_api.data.responses.ForecastInfo
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Service for working with obtaining weather data
 */
interface WeatherApiService {

    /**
     * Supportive object
     *
     * @property CURRENT_WEATHER URL for getting current weather data
     * @property SEVEN_DAY_FORECAST URL for getting seven day forecast
     */
    companion object{
        const val CURRENT_WEATHER = "data/2.5/weather"
        const val SEVEN_DAY_FORECAST = "data/2.5/forecast"
    }

    /**
     * Getting current weather
     *
     * @param city Name of city
     * @param apiKey API key
     * @param units Unit of measurement
     */
    @GET(CURRENT_WEATHER)
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String = "7bd809a46137d450c7abc5255a280afe",
        @Query("units") units: String
    ): CurrentWeatherInfo

    /**
     * Getting seven day forecast
     *
     * @param city Name of city
     * @param apiKey API key
     * @param units Unit of measurement (by default metric system)
     */
    @GET(SEVEN_DAY_FORECAST)
    suspend fun getSevenDayForecast(
        @Query("q") city: String,
        @Query("appid") apiKey: String = "7bd809a46137d450c7abc5255a280afe",
        @Query("units") units: String
    ): ForecastInfo
}