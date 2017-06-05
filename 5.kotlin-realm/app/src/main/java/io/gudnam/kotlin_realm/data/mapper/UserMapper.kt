package io.gudnam.kotlin_realm.data.mapper

import io.gudnam.kotlin_realm.data.api.model.CloudUser
import io.gudnam.kotlin_realm.domain.entity.User

/**
 * Created by gudnam on 2017. 5. 11..
 */
class UserMapper {

    fun transform(user: CloudUser) = user.phoneNumber?.let {
        User(user.phoneNumber, "", user.name)
    }
}