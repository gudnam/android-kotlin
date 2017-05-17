package io.gudnam.kotlin_retrofit.repository

import io.gudnam.kotlin_retrofit.domain.repository.AuthRepository
import io.gudnam.kotlin_retrofit.repository.dataset.AuthDataSet

/**
 * Created by gudnam on 2017. 5. 12..
 */
class AuthRepositoryImpl(val authDataSet: AuthDataSet) : AuthRepository {

    override fun getData(phoneNumber: String) = authDataSet.requestAuthNumber(phoneNumber)

}