package com.example.core.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


class ViewModelFactory<VM : ViewModel> @Inject constructor(
    private val viewModelProvider: Provider<VM>
) : ViewModelProvider.Factory {

    /**
     * @return Просто возвращает instance вьюмодели, полученной из Dagger.Provider, предоставленный Dagger-ом
     */
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(clazz: Class<T>): T = viewModelProvider.get() as T
}