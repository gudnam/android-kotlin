package io.gudnam.kotlin_retrofit.repository.dataset

import io.gudnam.kotlin_retrofit.domain.entity.Auth

/**
 * Created by gudnam on 2017. 5. 12..
 */
interface AuthDataSet {

    fun requestAuthNumber(phoneNumber: String): Auth?
}