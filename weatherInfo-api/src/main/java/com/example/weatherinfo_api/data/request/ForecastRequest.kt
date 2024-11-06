package com.example.weatherinfo_api.data.request

/**
 * DTO for request of forecast
 *
 * @property city Name of city
 * @property units Unit of measurement
 */
data class ForecastRequest(
    val city: String,
    val units: String
)
