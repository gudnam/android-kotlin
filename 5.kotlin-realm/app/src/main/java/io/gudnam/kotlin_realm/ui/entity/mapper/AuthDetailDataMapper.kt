package io.gudnam.kotlin_realm.ui.entity.mapper

import io.gudnam.kotlin_realm.domain.entity.Auth
import io.gudnam.kotlin_realm.ui.entity.AuthDetail

/**
 * Created by gudnam on 2017. 5. 12..
 */
class AuthDetailDataMapper {

    fun transform(auth: Auth?) = auth?.let { AuthDetail(auth.data) }
}