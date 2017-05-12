package io.gudnam.kotlin_retrofit.di.subcomponent.auth

import io.gudnam.kotlin_retrofit.domain.interactor.base.Bus
import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_retrofit.di.FragmentModule
import io.gudnam.kotlin_retrofit.di.scope.FragmentScope
import io.gudnam.kotlin_retrofit.ui.presenter.IdentifyPresenter
import io.gudnam.kotlin_retrofit.ui.screen.auth.IdentifyFragment
import io.gudnam.kotlin_retrofit.ui.view.IdentifyView

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
class IdentifyFragmentModule(fragment: IdentifyFragment) : FragmentModule(fragment) {

    @Provides @FragmentScope
    fun provideIdentifyView(): IdentifyView = fragment as IdentifyView

    @Provides @FragmentScope
    fun provideIdentifyPresenter(view: IdentifyView,
                                 bus: Bus) = IdentifyPresenter(view, bus)
}