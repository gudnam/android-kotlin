package io.gudnam.kotlin_mvp.domain.interactor.event

import io.gudnam.kotlin_mvp.domain.entity.UserInfo
import io.gudnam.kotlin_mvp.domain.interactor.base.Event

/**
 * Created by gudnam on 2017. 3. 22..
 */
class UserInfoEvent(val userInfo: UserInfo) : Event