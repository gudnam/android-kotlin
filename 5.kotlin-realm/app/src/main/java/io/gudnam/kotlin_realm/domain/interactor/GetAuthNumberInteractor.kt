package io.gudnam.kotlin_realm.domain.interactor

import io.gudnam.kotlin_realm.domain.interactor.base.Event
import io.gudnam.kotlin_realm.domain.interactor.base.Interactor
import io.gudnam.kotlin_realm.domain.interactor.event.AuthEvent
import io.gudnam.kotlin_realm.domain.repository.AuthRepository

/**
 * Created by gudnam on 2017. 5. 12..
 */
class GetAuthNumberInteractor(val authRepository: AuthRepository) : Interactor {

    var phoneNumber: String? = null

    override fun invoke(): Event {
        val phoneNumber = this.phoneNumber ?: throw IllegalStateException("phone number can`t be null")
        val auth = authRepository.getData(phoneNumber)
        return AuthEvent(auth)
    }

}