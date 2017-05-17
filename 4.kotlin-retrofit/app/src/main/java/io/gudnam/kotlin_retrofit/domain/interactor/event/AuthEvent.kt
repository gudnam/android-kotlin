package io.gudnam.kotlin_retrofit.domain.interactor.event

import io.gudnam.kotlin_retrofit.domain.entity.Auth
import io.gudnam.kotlin_retrofit.domain.interactor.base.Event

/**
 * Created by gudnam on 2017. 3. 22..
 */
class AuthEvent(val auth: Auth?) : Event