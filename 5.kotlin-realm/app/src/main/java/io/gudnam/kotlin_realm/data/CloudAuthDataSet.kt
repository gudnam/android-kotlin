package io.gudnam.kotlin_realm.data

import io.gudnam.kotlin_realm.data.api.APIService
import io.gudnam.kotlin_realm.data.mapper.AccessTokenMapper
import io.gudnam.kotlin_realm.data.mapper.AuthMapper
import io.gudnam.kotlin_realm.data.repository.dataset.AuthDataSet
import io.gudnam.kotlin_realm.domain.entity.Auth
import io.gudnam.kotlin_realm.domain.entity.User

/**
 * Created by gudnam on 2017. 5. 12..
 */
class CloudAuthDataSet(val apiService: APIService) : AuthDataSet {

    override fun requestAuthNumber(phoneNumber: String): Auth? =
            apiService.requestAuthNumber(phoneNumber).unwrapCall {
                AuthMapper().transform(data)
            }
    override fun requestAccessToken(phoneNumber: String, authNumber: String): User? =
            apiService.requestAccessToken(phoneNumber, authNumber).unwrapCall {
                AccessTokenMapper().transform(data, phoneNumber)
            }

}