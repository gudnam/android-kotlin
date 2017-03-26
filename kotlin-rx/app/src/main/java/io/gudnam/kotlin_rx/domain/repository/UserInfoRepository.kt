package io.gudnam.kotlin_rx.domain.repository

import io.gudnam.kotlin_rx.domain.entity.UserInfo

/**
 * Created by gudnam on 2017. 3. 22..
 */
interface UserInfoRepository {
    fun getUserInfoList(): List<UserInfo>
    fun getUserInfo(id: Int): UserInfo?
}