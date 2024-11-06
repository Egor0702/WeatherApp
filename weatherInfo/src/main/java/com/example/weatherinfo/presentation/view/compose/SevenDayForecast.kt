package com.example.weatherinfo.presentation.view.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.res.painterResource
import com.example.weatherinfo.R

@Composable
fun SevenDayForecast() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(7) { index ->
            DayForecastCard(
                day = "Day $index",
                temperature = "${20 + index}°C",
                iconId = R.drawable.ic_sun
            )
        }
    }
}

@Composable
fun DayForecastCard(day: String, temperature: String, iconId: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(80.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = day, style = MaterialTheme.typography.subtitle1)
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Text(text = temperature, style = MaterialTheme.typography.h6)
        }
    }
}