package com.example.weatherinfo_api.data.responses

/**
 * DTO for seven day forecast
 *
 * @property city [CityInfo]
 * @property list List of [DailyWeather]
 */
data class ForecastInfo(
    val city: CityInfo,
    val list: List<DailyWeather>
)

/**
 * Information about city
 *
 * @property name Name of city
 * @property country Name of country
 */
data class CityInfo(
    val name: String,
    val country: String
)

/**
 * Сlass represents the weather data for a specific day
 *
 * @property dt The time of forecast
 * @property temp Info about temperature
 * @property weather List of [WeatherDescription]
 */
data class DailyWeather(
    val dt: Long,
    val temp: TempInfo,
    val weather: List<WeatherDescription>
)

/**
 * Сlass represents the temperature data
 *
 * @property day Daytime temperature
 * @property night Nighttime temperature
 */
data class TempInfo(
    val day: Float,
    val night: Float
)
