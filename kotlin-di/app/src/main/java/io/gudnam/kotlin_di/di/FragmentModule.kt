package io.gudnam.kotlin_di.di

import android.content.Context
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_di.di.scope.FragmentScope

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
abstract class FragmentModule(protected val fragment: Fragment) {

    @Provides @FragmentScope
    fun provideFragment(): Fragment = fragment

    @Provides @FragmentScope
    fun provideContext(): Context = fragment.context
}