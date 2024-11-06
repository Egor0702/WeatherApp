package com.example.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import com.example.core.di.ViewModelFactory
import com.example.core.navigation.BaseScreen
import com.example.core.presentation.viewModel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel> :
    Fragment() {

    abstract val viewModelFactory: ViewModelFactory<VM>

    val viewModel: VM by lazy {
        ViewModelProvider(this, viewModelFactory)[getViewModelClass()]
    }

    abstract val viewModelType: Class<VM>


    @Composable
    abstract fun GetComposableContent()

    abstract fun getViewModelClass(): Class<VM>


    @CallSuper
    protected open fun observeViewModel() {
        lifecycle.addObserver(viewModel as LifecycleObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    GetComposableContent()
                }
            }
        }
    }

    /**
     * Call reInit for viewModel
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeViewModel()
        val args = arguments
        if (args?.getBoolean(BaseScreen.reinitViewModelKey) == true) {
            viewModel.init(args)
        }
    }
}