package io.gudnam.kotlin_retrofit.domain.interactor.base

/**
 * Created by gudnam on 2017. 3. 22..
 */
interface Interactor {

    operator fun invoke(): Event
}