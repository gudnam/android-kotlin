package io.gudnam.kotlin_mvp.ui.presenter

/**
 * Created by gudnam on 2017. 3. 21..
 */
interface Presenter<out T> {

    val view: T
}