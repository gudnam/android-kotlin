package io.gudnam.kotlin_realm.di

import dagger.Component
import io.gudnam.kotlin_realm.di.subcomponent.auth.IdentifyFragmentComponent
import io.gudnam.kotlin_realm.di.subcomponent.auth.IdentifyFragmentModule
import io.gudnam.kotlin_realm.di.subcomponent.auth.PhoneNumberFragmentComponent
import io.gudnam.kotlin_realm.di.subcomponent.auth.PhoneNumberFragmentModule
import javax.inject.Singleton

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        DataModule::class,
        RepositoryModule::class,
        DomainModule::class
))
interface ApplicationComponent {

    fun plus(module: PhoneNumberFragmentModule): PhoneNumberFragmentComponent
    fun plus(module: IdentifyFragmentModule): IdentifyFragmentComponent

}