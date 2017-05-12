package io.gudnam.kotlin_retrofit.repository

import io.gudnam.kotlin_retrofit.domain.entity.User
import io.gudnam.kotlin_retrofit.domain.repository.UserRepository
import java.util.*

/**
 * Created by gudnam on 2017. 3. 23..
 */
class UserRepositoryImpl : UserRepository {

    fun getList() : List<User> {
        var list = ArrayList<User>()
        list.add(User("01011112222", "", "gudnam"))
        list.add(User("01011112222", "", "bbu"))
        return list
    }

    override fun getUserList(): List<User> {
        return getList()
    }

    override fun getUser(phoneNumber: String): User? {
        var user: User? = getList().filter { it.phoneNumber == phoneNumber }[0]

        return user
    }
}