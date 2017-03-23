package io.gudnam.kotlin_mvp.ui.presenter

import io.gudnam.kotlin_mvp.domain.interactor.FindUserInfoInteractor
import io.gudnam.kotlin_mvp.domain.interactor.event.UserInfoEvent
import io.gudnam.kotlin_mvp.ui.view.MainView

/**
 * Created by gudnam on 2017. 3. 21..
 */
class MainPresenter(
        override val view: MainView,
        val interactor: FindUserInfoInteractor) : Presenter<MainView> {

    fun onResume() {
        interactor.id = 0
        interactor.setOnCallback {
            var event = it as UserInfoEvent
            view.showUserName(event.userInfo.name)
        }
    }
}