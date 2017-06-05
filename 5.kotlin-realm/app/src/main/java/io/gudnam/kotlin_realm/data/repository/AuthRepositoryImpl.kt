package io.gudnam.kotlin_realm.data.repository

import io.gudnam.kotlin_realm.data.repository.dataset.AuthDataSet
import io.gudnam.kotlin_realm.domain.entity.User
import io.gudnam.kotlin_realm.domain.repository.AuthRepository

/**
 * Created by gudnam on 2017. 5. 12..
 */
class AuthRepositoryImpl(val authDataSet: AuthDataSet) : AuthRepository {

    override fun getData(phoneNumber: String) = authDataSet.requestAuthNumber(phoneNumber)
    override fun getAccessToken(phoneNumber: String, authNumber: String) = authDataSet.requestAccessToken(phoneNumber, authNumber)
}