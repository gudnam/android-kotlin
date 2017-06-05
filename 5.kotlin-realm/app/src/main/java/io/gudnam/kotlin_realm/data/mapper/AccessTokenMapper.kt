package io.gudnam.kotlin_realm.data.mapper

import io.gudnam.kotlin_realm.data.api.model.CloudAccessToken
import io.gudnam.kotlin_realm.domain.entity.User

/**
 * Created by gudnam on 2017. 5. 12..
 */
class AccessTokenMapper {

    fun transform(accessToken: CloudAccessToken?, phoneNumber: String) = accessToken?.let { User(phoneNumber, it.AccessToken, "") }
}