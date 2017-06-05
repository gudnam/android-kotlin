package io.gudnam.kotlin_realm.domain.repository

import io.gudnam.kotlin_realm.domain.entity.User

/**
 * Created by gudnam on 2017. 3. 22..
 */
interface UserRepository {
    fun getUserList(): List<User>
    fun getUser(phoneNumber: String): User?
}