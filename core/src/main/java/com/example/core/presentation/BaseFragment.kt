package com.example.core.presentation

import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.core.di.ViewModelFactory
import com.example.core.presentation.viewModel.BaseViewModel
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, B : ViewBinding> :
    Fragment() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory<VM>

    val viewModel: VM by lazy {
        getViewModelInstance()
    }

    abstract val viewModelType: Class<VM>

    protected abstract fun createViewBinding(): B

    /**
     * Получение ViewModel
     */
    protected open fun getViewModelInstance(): VM {
        return ViewModelProvider(this as Fragment, viewModelFactory)[viewModelType]
    }

    abstract fun inject()


    @CallSuper
    protected open fun observeViewModel() {
        lifecycle.addObserver(viewModel as LifecycleObserver)
    }

}