package io.gudnam.kotlin_realm.domain.interactor

import io.gudnam.kotlin_realm.domain.interactor.base.Event
import io.gudnam.kotlin_realm.domain.interactor.base.Interactor
import io.gudnam.kotlin_realm.domain.interactor.event.UserInfoEvent
import io.gudnam.kotlin_realm.data.repository.UserRepositoryImpl

/**
 * Created by gudnam on 2017. 3. 22..
 */
class FindUserInfoInteractor : Interactor {

    var phoneNumber: String = ""

    override fun invoke(): Event {
        var repository = UserRepositoryImpl()
        val userInfo = repository.getUser(phoneNumber)
        return UserInfoEvent(userInfo)
    }
}