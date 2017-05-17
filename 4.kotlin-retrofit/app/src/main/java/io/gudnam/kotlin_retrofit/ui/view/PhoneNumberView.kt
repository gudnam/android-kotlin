package io.gudnam.kotlin_retrofit.ui.view

import io.reactivex.Observable

/**
 * Created by gudnam on 2017. 4. 27..
 */
interface PhoneNumberView : PresentationView {
    fun showLastEditedPhoneNumber(text: String)
    fun nextView()
    fun showNextButton()
    fun hideNextButton()
    fun subscribe(observable: Observable<String>)
    fun showMessage(message: String)
}