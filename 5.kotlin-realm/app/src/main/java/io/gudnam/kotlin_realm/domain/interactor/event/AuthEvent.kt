package io.gudnam.kotlin_realm.domain.interactor.event

import io.gudnam.kotlin_realm.domain.entity.Auth
import io.gudnam.kotlin_realm.domain.interactor.base.Event

/**
 * Created by gudnam on 2017. 3. 22..
 */
class AuthEvent(val auth: Auth?) : Event