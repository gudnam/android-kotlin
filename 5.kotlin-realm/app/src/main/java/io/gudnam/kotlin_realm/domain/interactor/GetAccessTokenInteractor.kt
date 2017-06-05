package io.gudnam.kotlin_realm.domain.interactor

import io.gudnam.kotlin_realm.domain.interactor.base.Event
import io.gudnam.kotlin_realm.domain.interactor.base.Interactor
import io.gudnam.kotlin_realm.domain.interactor.event.AccessTokenEvent
import io.gudnam.kotlin_realm.domain.repository.AuthRepository

/**
 * Created by gudnam on 2017. 5. 12..
 */
class GetAccessTokenInteractor(val authRepository: AuthRepository) : Interactor {

    var phoneNumber: String? = null
    var authNumber: String? = null

    override fun invoke(): Event {
        val phoneNumber = this.phoneNumber ?: throw IllegalStateException("phone number can`t be null")
        val authNumber = this.authNumber ?: throw IllegalStateException("auth number can`t be null")
        val user = authRepository.getAccessToken(phoneNumber, authNumber)
        return AccessTokenEvent(user)
    }

}