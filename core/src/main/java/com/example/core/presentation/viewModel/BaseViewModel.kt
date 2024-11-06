package com.example.core.presentation.viewModel

import android.os.Bundle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), LifecycleObserver {

    /**
     * Method for initializing the viewmodel.
     *
     * @param args Additional parameters obtained during navigation
     */
    open fun init(args: Bundle) {}
}