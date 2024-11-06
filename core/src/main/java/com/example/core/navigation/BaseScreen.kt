package com.example.core.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Base class with information about screen being opened
 */
abstract class BaseScreen: Screen {

    /**
     * Object for declaring constant
     *
     * @property reinitViewModelKey The key by which the Bundle stores the indication of the need to reinitialize the viewmodel
     */
    companion object {
        const val reinitViewModelKey = "reinitVMKey"
    }

    open var args: Bundle? = null

    /**
     * Method for getting new instance required for fragment's screen Метод получения нового экземпляра нужного для экрана фрагмента
     */
    abstract fun getFragmentInstance(): Fragment

    /**
     * Initialization of fragment for sending in Cicerone.Router
     */
    fun createFragment(): Fragment {
        Log.d("Egor", "createFragment()")
        val args = args ?: Bundle()
        args.putBoolean(reinitViewModelKey, true)

        val fragment = getFragmentInstance()
        fragment.arguments = (fragment.arguments ?: Bundle()).apply {
            putAll(args)
        }

        return fragment
    }
}

/**
 * BaseScreen to FragmentScreen
 *
 * @param clearContainer Flag to clear the container if it is true a fragment will be replaced vice versa will be added
 */
fun BaseScreen.toFragmentScreen(clearContainer: Boolean = true) =
    FragmentScreen(key = this.screenKey, clearContainer = clearContainer) {
        Log.d("Egor", "toFragmentScreen")
        this.createFragment()
    }