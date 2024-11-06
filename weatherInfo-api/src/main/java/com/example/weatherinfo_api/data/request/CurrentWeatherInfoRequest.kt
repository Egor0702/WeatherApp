package com.example.weatherinfo_api.data.request

/**
 * DTO for request of current weather info
 *
 * @property city Name of city
 * @property units Unit of measurement
 */
data class CurrentWeatherInfoRequest(
    val city: String,
    val units: String
)
