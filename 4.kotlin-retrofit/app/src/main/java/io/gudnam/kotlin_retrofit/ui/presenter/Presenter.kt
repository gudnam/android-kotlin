package io.gudnam.kotlin_retrofit.ui.presenter

import io.gudnam.kotlin_retrofit.domain.interactor.base.Bus

/**
 * Created by gudnam on 2017. 3. 21..
 */
interface Presenter<out T> {

    val view: T
    val bus: Bus

    fun onResume(){
        bus.register(this)
    }

    fun onPause(){
        bus.unregister(this)
    }
}