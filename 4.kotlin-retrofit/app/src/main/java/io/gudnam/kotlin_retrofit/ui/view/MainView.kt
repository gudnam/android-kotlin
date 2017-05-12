package io.gudnam.kotlin_retrofit.ui.view

import io.reactivex.Observable

/**
 * Created by gudnam on 2017. 3. 21..
 */
interface MainView : PresentationView {

    fun createButtonClickObservable(): Observable<String>
    fun subscribe(observable: Observable<String>)
    fun showProgressbar()
    fun hideProgressbar()
    fun showButton()
    fun hideButton()
}