package io.gudnam.kotlin_retrofit.data.mapper

import io.gudnam.kotlin_retrofit.data.api.model.CloudAuth
import io.gudnam.kotlin_retrofit.domain.entity.Auth

/**
 * Created by gudnam on 2017. 5. 12..
 */
class AuthMapper {

    fun transform(auth: CloudAuth?) = auth?.let { Auth(it.result) }
}