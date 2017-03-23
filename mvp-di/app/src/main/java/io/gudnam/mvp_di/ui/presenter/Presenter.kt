package io.gudnam.mvp_di.ui.presenter

/**
 * Created by gudnam on 2017. 3. 21..
 */
interface Presenter<out T> {

    val view: T
}