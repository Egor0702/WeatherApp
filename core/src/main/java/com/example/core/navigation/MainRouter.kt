package com.example.core.navigation

import android.util.Log
import com.github.terrakok.cicerone.BackTo
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.Router

/**
 * An extension of the standard Cicerone class.Router
 */
class MainRouter: Router() {

    /**
     * The command navigation. See Router.newRootScreen
     *
     * @param screen Экран
     */
    fun newRootScreen(screen: BaseScreen) {
        Log.d("Egor", "newRootScreen $screen")
        executeCommands(BackTo(null), Replace(screen.toFragmentScreen()))
    }
}