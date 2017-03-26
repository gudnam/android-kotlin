package io.gudnam.kotlin_rx.domain.interactor.event

import io.gudnam.kotlin_rx.domain.entity.UserInfo
import io.gudnam.kotlin_rx.domain.interactor.base.Event

/**
 * Created by gudnam on 2017. 3. 22..
 */
class UserInfoEvent(val userInfo: UserInfo) : Event