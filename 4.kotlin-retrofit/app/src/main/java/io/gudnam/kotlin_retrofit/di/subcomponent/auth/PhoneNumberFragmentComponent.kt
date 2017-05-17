package io.gudnam.kotlin_retrofit.di.subcomponent.auth

import dagger.Subcomponent
import io.gudnam.kotlin_retrofit.di.scope.FragmentScope
import io.gudnam.kotlin_retrofit.ui.screen.auth.PhoneNumberFragment

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