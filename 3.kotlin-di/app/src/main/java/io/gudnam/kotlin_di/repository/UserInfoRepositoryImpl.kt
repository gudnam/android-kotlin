package io.gudnam.kotlin_di.repository

import io.gudnam.kotlin_di.domain.entity.UserInfo
import io.gudnam.kotlin_di.domain.repository.UserInfoRepository
import java.util.*

/**
 * Created by gudnam on 2017. 3. 23..
 */
class UserInfoRepositoryImpl : UserInfoRepository {

    fun getList() : List<UserInfo> {
        var list = ArrayList<UserInfo>()
        list.add(UserInfo(0, "gudnam"))
        list.add(UserInfo(1, "bbu"))
        return list
    }

    override fun getUserInfoList(): List<UserInfo> {
        return getList()
    }

    override fun getUserInfo(id: Int): UserInfo? {
        var userInfo: UserInfo? = getList().filter { it.id == id }[0]

        return userInfo
    }
}