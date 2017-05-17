package io.gudnam.kotlin_retrofit.domain.interactor

import io.gudnam.kotlin_retrofit.domain.interactor.base.Event
import io.gudnam.kotlin_retrofit.domain.interactor.base.Interactor
import io.gudnam.kotlin_retrofit.domain.interactor.event.UserInfoEvent
import io.gudnam.kotlin_retrofit.repository.UserRepositoryImpl

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