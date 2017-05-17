package io.gudnam.kotlin_retrofit.di.subcomponent.auth

import dagger.Subcomponent
import io.gudnam.kotlin_retrofit.di.scope.FragmentScope
import io.gudnam.kotlin_retrofit.ui.screen.auth.IdentifyFragment

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