package io.gudnam.kotlin_di.domain.repository

import io.gudnam.kotlin_di.domain.entity.UserInfo

/**
 * Created by gudnam on 2017. 3. 22..
 */
interface UserInfoRepository {
    fun getUserInfoList(): List<UserInfo>
    fun getUserInfo(id: Int): UserInfo?
}