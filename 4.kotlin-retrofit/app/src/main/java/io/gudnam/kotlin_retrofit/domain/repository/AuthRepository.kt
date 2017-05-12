package io.gudnam.kotlin_retrofit.domain.repository

import io.gudnam.kotlin_retrofit.domain.entity.Auth

/**
 * Created by gudnam on 2017. 5. 12..
 */
interface AuthRepository {
    fun getData(phoneNumber: String) : Auth?
}