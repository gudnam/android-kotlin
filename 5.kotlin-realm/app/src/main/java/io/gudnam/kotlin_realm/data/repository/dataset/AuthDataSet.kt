package io.gudnam.kotlin_realm.data.repository.dataset

import io.gudnam.kotlin_realm.domain.entity.Auth
import io.gudnam.kotlin_realm.domain.entity.User

/**
 * Created by gudnam on 2017. 5. 12..
 */
interface AuthDataSet {

    fun requestAuthNumber(phoneNumber: String): Auth?
    fun requestAccessToken(phoneNumber: String, authNumber: String): User?
}