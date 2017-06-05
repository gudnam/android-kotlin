package io.gudnam.kotlin_realm.di.subcomponent.auth

import dagger.Subcomponent
import io.gudnam.kotlin_realm.di.scope.FragmentScope
import io.gudnam.kotlin_realm.ui.screen.auth.PhoneNumberFragment

/**
 * Created by gudnam on 2017. 4. 27..
 */
@FragmentScope
@Subcomponent(modules = arrayOf(
        PhoneNumberFragmentModule::class
))
interface PhoneNumberFragmentComponent {

    fun injectTo(fragment: PhoneNumberFragment)
}