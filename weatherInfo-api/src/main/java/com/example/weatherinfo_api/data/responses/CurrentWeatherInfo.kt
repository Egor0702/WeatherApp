package com.example.weatherinfo_api.data.responses

/**
 * DTO for current weather data
 *
 * @property weather List of weather descriptions
 * @param main [WeatherMainInfo]
 * @param wind [WindInfo]
 * @property name Name of city
 * @property sys Information about country
 */
data class CurrentWeatherInfo(
    val weather: List<WeatherDescription>,
    val main: WeatherMainInfo,
    val wind: WindInfo,
    val name: String,
    val sys: SysInfo
)

/**
 * Class with description of weather
 *
 * @param main basic information
 * @param description Description (e.g. "clear sky")
 */
data class WeatherDescription(
    val main: String,
    val description: String
)

/**
 * Basic information about weather
 *
 * @param temp Value of temperature
 * @param humidity Value of humidity
 * @property pressure Value of pressure
 */
data class WeatherMainInfo(
    val temp: Float,
    val humidity: Int,
    val pressure: Int
)

/**
 * Information about wind
 *
 * @param speed Speed of wind
 */
data class WindInfo(
    val speed: Float
)

/**
 * Information about country
 *
 * @property country Name of country (e.g. "USA")
 */
data class SysInfo(
    val country: String
)
