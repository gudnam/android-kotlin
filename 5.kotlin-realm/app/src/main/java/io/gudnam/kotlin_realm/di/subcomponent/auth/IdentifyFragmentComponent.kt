package io.gudnam.kotlin_realm.di.subcomponent.auth

import dagger.Subcomponent
import io.gudnam.kotlin_realm.di.scope.FragmentScope
import io.gudnam.kotlin_realm.ui.screen.auth.IdentifyFragment

/**
 * Created by gudnam on 2017. 4. 27..
 */
@FragmentScope
@Subcomponent(modules = arrayOf(
        IdentifyFragmentModule::class
))
interface IdentifyFragmentComponent {

    fun injectTo(fragment: IdentifyFragment)
}