package com.example.core.di

import com.example.core.navigation.MainRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {
    private val cicerone: Cicerone<MainRouter> = Cicerone.create(MainRouter())

    /**
     * Предоставить роутер
     */
    @Provides
    fun provideRouter(): MainRouter = cicerone.router

    /**
     * Предоставить navigatorHolder
     */
    @Provides
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

}