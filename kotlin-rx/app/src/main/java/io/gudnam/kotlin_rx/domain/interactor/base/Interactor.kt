package io.gudnam.kotlin_rx.domain.interactor.base

/**
 * Created by gudnam on 2017. 3. 22..
 */
interface Interactor {

    fun setOnCallback(callback: ((Event)->Unit))
}