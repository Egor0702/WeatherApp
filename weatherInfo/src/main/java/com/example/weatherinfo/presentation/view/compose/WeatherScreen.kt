package com.example.weatherinfo.presentation.view.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.utils.DataHolder
import com.example.weatherinfo.presentation.viewModel.WeatherInfoViewModel

@Composable
fun WeatherScreen(viewModel: WeatherInfoViewModel) {

    val currentWeatherInfo = viewModel.currentWeatherInfoState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Weather in Your City") },
                actions = {
                    IconButton(onClick = { /* refresh logic */ }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        }
    ) { paddingValues ->
        when (currentWeatherInfo.value) {
            is DataHolder.LOADING -> {
                Shimmer()
            }
            is DataHolder.READY, null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CurrentWeatherSection(
                        temperature = "25°C",
                        weatherDescription = "Sunny",
                        humidity = 65,
                        windSpeed = 10,
                        pressure = 1012
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "7-Day Forecast", style = MaterialTheme.typography.h6)

                    Spacer(modifier = Modifier.height(8.dp))

                    SevenDayForecast()

                    Spacer(modifier = Modifier.height(16.dp))

                    TemperatureGraph() // Simple temperature graph
                }
            }
            is DataHolder.ERROR -> {
                //TODO refactor
                Text(
                    text = "Error: ${(currentWeatherInfo.value as DataHolder.ERROR).failure.message}",
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}