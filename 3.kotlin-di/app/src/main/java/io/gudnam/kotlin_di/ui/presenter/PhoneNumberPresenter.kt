package io.gudnam.kotlin_di.ui.presenter

import io.gudnam.kotlin_di.domain.interactor.FindUserInfoInteractor
import io.gudnam.kotlin_di.ui.view.PhoneNumberView

/**
 * Created by gudnam on 2017. 4. 27..
 */
class PhoneNumberPresenter(
        override val view: PhoneNumberView,
        val findUserInfoInteractor: FindUserInfoInteractor) : Presenter<PhoneNumberView> {

    fun onResume() {
        view.showLastEditedPhoneNumber("01011112222")
    }

}