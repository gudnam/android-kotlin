package io.gudnam.kotlin_retrofit.data.mapper

import io.gudnam.kotlin_retrofit.data.api.model.CloudUser
import io.gudnam.kotlin_retrofit.domain.entity.User

/**
 * Created by gudnam on 2017. 5. 11..
 */
class UserMapper {

    fun transform(user: CloudUser) = user.phoneNumber?.let {
        User(user.phoneNumber, "", user.name)
    }
}