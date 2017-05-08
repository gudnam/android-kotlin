package io.gudnam.kotlin_di.di

import dagger.Component
import io.gudnam.kotlin_di.di.subcomponent.auth.PhoneNumberFragmentComponent
import io.gudnam.kotlin_di.di.subcomponent.auth.PhoneNumberFragmentModule
import javax.inject.Singleton

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        RepositoryModule::class,
        DomainModule::class
))
interface ApplicationComponent {

    fun plus(module: PhoneNumberFragmentModule): PhoneNumberFragmentComponent

}