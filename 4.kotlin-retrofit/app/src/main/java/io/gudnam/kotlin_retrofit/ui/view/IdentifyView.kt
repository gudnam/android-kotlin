package io.gudnam.kotlin_retrofit.ui.view

import io.reactivex.Observable

/**
 * Created by gudnam on 2017. 4. 27..
 */
interface IdentifyView : PresentationView {
    fun nextView()
    fun showNextButton()
    fun hideNextButton()
    fun subscribe(observable: Observable<String>)
}