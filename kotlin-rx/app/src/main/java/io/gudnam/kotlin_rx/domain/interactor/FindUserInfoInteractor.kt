package io.gudnam.kotlin_rx.domain.interactor

import io.gudnam.kotlin_rx.domain.interactor.base.Event
import io.gudnam.kotlin_rx.domain.interactor.base.Interactor
import io.gudnam.kotlin_rx.domain.interactor.event.UserInfoEvent
import io.gudnam.kotlin_rx.repository.UserInfoRepositoryImpl

/**
 * Created by gudnam on 2017. 3. 22..
 */
class FindUserInfoInteractor() : Interactor {

    var id: Int = 0

    override fun setOnCallback(callback: ((Event)->Unit)) {
        var repository = UserInfoRepositoryImpl()
        val userInfo = repository.getUserInfo(id)
        userInfo?.let { callback.invoke(UserInfoEvent(it)) }
    }
}