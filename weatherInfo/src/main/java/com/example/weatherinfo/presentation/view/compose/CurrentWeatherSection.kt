package com.example.weatherinfo.presentation.view.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material.Text
import com.example.weatherinfo.R
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable

@Composable
fun CurrentWeatherSection(
    temperature: String,
    weatherDescription: String,
    humidity: Int,
    windSpeed: Int,
    pressure: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_sun), // Your weather icon here
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
        Text(text = temperature, style = MaterialTheme.typography.h3)
        Text(text = weatherDescription, style = MaterialTheme.typography.subtitle1)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherInfoCard("Humidity", "$humidity%")
            WeatherInfoCard("Wind", "$windSpeed km/h")
            WeatherInfoCard("Pressure", "$pressure hPa")
        }
    }
}