package com.example.weatherinfo.di

import com.example.core.di.ViewModelFactory
import com.example.weatherinfo.presentation.viewModel.WeatherInfoViewModel
import com.example.weatherinfo_api.data.WeatherApiService
import com.example.weatherinfo_api.data.WeatherInfoRepository
import com.example.weatherinfo_api.data.WeatherInfoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Provider

@Module
@InstallIn(FragmentComponent::class)
object WeatherInfoModule {
    @Provides
    fun provideWeatherInfoViewModelFactory(
        weatherInfoViewModelProvider: Provider<WeatherInfoViewModel>
    ): ViewModelFactory<WeatherInfoViewModel> {
        return ViewModelFactory(weatherInfoViewModelProvider)
    }

    @Provides
    fun provideWeatherInfoRepository(
        weatherApiService: WeatherApiService
    ): WeatherInfoRepository {
        return WeatherInfoRepositoryImpl(weatherApiService)
    }
}