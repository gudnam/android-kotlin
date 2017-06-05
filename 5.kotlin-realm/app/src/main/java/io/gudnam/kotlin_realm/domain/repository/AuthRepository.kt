package io.gudnam.kotlin_realm.domain.repository

import io.gudnam.kotlin_realm.domain.entity.Auth
import io.gudnam.kotlin_realm.domain.entity.User

/**
 * Created by gudnam on 2017. 5. 12..
 */
interface AuthRepository {
    fun getData(phoneNumber: String) : Auth?
    fun getAccessToken(phoneNumber: String, authNumber: String) : User?
}