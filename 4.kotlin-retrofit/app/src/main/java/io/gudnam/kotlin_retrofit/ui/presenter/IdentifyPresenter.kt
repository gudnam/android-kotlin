package io.gudnam.kotlin_retrofit.ui.presenter

import io.gudnam.kotlin_retrofit.domain.interactor.base.Bus
import io.gudnam.kotlin_retrofit.ui.view.IdentifyView
import io.reactivex.Observable

/**
 * Created by gudnam on 2017. 4. 27..
 */
class IdentifyPresenter(
        override val view: IdentifyView,
        override val bus: Bus) : Presenter<IdentifyView> {

    fun onResume(createPhoneNumberTextChangeObservable: Observable<String>, createNextButtonClickObservable: Observable<String>) {
        view.hideNextButton()
        view.subscribe(Observable.merge(createPhoneNumberTextChangeObservable, createNextButtonClickObservable))
    }

    fun onNextButtonClicked(phoneNumber: String) {
        if (checkIsValidData(phoneNumber))
            view.nextView()
    }

    fun onNext(result: Boolean) {
        if (result)
            view.showNextButton()
        else
            view.hideNextButton()
    }

    fun checkIsValidData(query: String?): Boolean {
        query?.let {
            if (it.length < 10)
                return false
            return true
        }
        return false
    }

    fun onError() {

    }

    fun onComplete() {

    }
}