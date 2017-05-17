package io.gudnam.kotlin_retrofit.ui.presenter

import io.gudnam.kotlin_retrofit.domain.interactor.base.Bus
import io.gudnam.kotlin_retrofit.domain.interactor.base.InteractorExecutor
import io.gudnam.kotlin_retrofit.domain.interactor.GetAuthNumberInteractor
import io.gudnam.kotlin_retrofit.domain.interactor.event.AuthEvent
import io.gudnam.kotlin_retrofit.ui.entity.mapper.AuthDetailDataMapper
import io.gudnam.kotlin_retrofit.ui.view.PhoneNumberView
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Created by gudnam on 2017. 4. 27..
 */
class PhoneNumberPresenter(
        override val view: PhoneNumberView,
        override val bus: Bus,
        val authNumberInteractor: GetAuthNumberInteractor,
        val interactorExcecutor: InteractorExecutor,
        val authDetailDataMapper: AuthDetailDataMapper) : Presenter<PhoneNumberView> {

    override fun onResume() {
        super.onResume()
        view.hideNextButton()
    }

    fun onNextButtonClicked(phoneNumber: String) {
        if (checkIsValidData(phoneNumber)) {
            authNumberInteractor.phoneNumber = phoneNumber
            interactorExcecutor.execute(authNumberInteractor)
        }
    }

    @Subscribe
    fun onMessageEvent(event: AuthEvent) {
        var authDetail = authDetailDataMapper.transform(event.auth)
        if (authDetail != null) {
            if (authDetail.data.equals("success"))
                view.nextView()
            else
                view.showMessage("잘못된 응답")
        } else
            view.showMessage("서버 요청 실패")
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