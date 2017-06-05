package io.gudnam.kotlin_realm.ui.presenter

import io.gudnam.kotlin_realm.domain.interactor.GetAccessTokenInteractor
import io.gudnam.kotlin_realm.domain.interactor.base.Bus
import io.gudnam.kotlin_realm.domain.interactor.base.InteractorExecutor
import io.gudnam.kotlin_realm.domain.interactor.event.AccessTokenEvent
import io.gudnam.kotlin_realm.ui.view.IdentifyView
import org.greenrobot.eventbus.Subscribe

/**
 * Created by gudnam on 2017. 4. 27..
 */
class IdentifyPresenter(
        override val view: IdentifyView,
        override val bus: Bus,
        val accessTokenInteractor: GetAccessTokenInteractor,
        val interactorExecutor: InteractorExecutor) : Presenter<IdentifyView> {

    override fun onResume() {
        super.onResume()
        view.hideNextButton()
    }

    fun onNextButtonClicked(phoneNumber: String, authNumber: String) {
        if (checkIsValidData(phoneNumber)) {
            accessTokenInteractor.phoneNumber = phoneNumber
            accessTokenInteractor.authNumber = authNumber
            interactorExecutor.execute(accessTokenInteractor)
        }
    }

    @Subscribe
    fun onMessageEvent(event: AccessTokenEvent) {
        var accessToken = event.user?.accessToken
        accessToken?.let { view.showMessage(it) }
    }

    fun onNext(result: Boolean) {
        if (result)
            view.showNextButton()
        else
            view.hideNextButton()
    }

    fun checkIsValidData(query: String?): Boolean {
        query?.let {
            if (it.length < 4)
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