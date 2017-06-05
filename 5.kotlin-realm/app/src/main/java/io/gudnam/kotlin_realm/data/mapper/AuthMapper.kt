package io.gudnam.kotlin_realm.data.mapper

import io.gudnam.kotlin_realm.data.api.model.CloudAuth
import io.gudnam.kotlin_realm.domain.entity.Auth

/**
 * Created by gudnam on 2017. 5. 12..
 */
class AuthMapper {

    fun transform(auth: CloudAuth?) = auth?.let { Auth(it.result) }
}