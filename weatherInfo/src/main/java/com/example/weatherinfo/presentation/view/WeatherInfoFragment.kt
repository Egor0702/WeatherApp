package com.example.weatherinfo.presentation.view

import android.util.Log
import androidx.compose.runtime.Composable
import com.example.core.di.ViewModelFactory
import com.example.core.extension.observeData
import com.example.core.presentation.BaseFragment
import com.example.weatherinfo.presentation.view.compose.WeatherScreen
import com.example.weatherinfo.presentation.viewModel.WeatherInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

/**
 * Fragment for showing weather info
 */
@AndroidEntryPoint
class WeatherInfoFragment: BaseFragment<WeatherInfoViewModel>() {
    override val viewModelType: Class<WeatherInfoViewModel>
        get() = WeatherInfoViewModel::class.java

    @Inject
    override lateinit var viewModelFactory: ViewModelFactory<WeatherInfoViewModel>

    // Возвращаем конкретный класс ViewModel
    override fun getViewModelClass(): Class<WeatherInfoViewModel> {
        return WeatherInfoViewModel::class.java
    }

    @Composable
    override fun GetComposableContent() {
        WeatherScreen(viewModel)
    }

    override fun onResume() {
        super.onResume()

        Log.d("Egor", "onResume()")
    }

    override fun observeViewModel() {
        super.observeViewModel()

        observeData(viewModel.currentWeatherInfoState) { state ->
            state?.onReady {
                // update ui
                Timber.tag("Egor").d("state?.onReady { $it")
            }
            state?.onLoading {
                // show shimmer
                Timber.tag("Egor").d("state?.onLoading")
            }
            state?.onError {
                // show error info
                Timber.tag("Egor").d("state?.onError ${it.cause} and ${it.message}")
            }
        }
    }
}