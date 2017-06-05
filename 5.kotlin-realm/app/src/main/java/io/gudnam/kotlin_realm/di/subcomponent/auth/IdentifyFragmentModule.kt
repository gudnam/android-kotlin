package io.gudnam.kotlin_realm.di.subcomponent.auth

import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_realm.di.FragmentModule
import io.gudnam.kotlin_realm.di.scope.FragmentScope
import io.gudnam.kotlin_realm.domain.interactor.GetAccessTokenInteractor
import io.gudnam.kotlin_realm.domain.interactor.base.Bus
import io.gudnam.kotlin_realm.domain.interactor.base.InteractorExecutor
import io.gudnam.kotlin_realm.ui.presenter.IdentifyPresenter
import io.gudnam.kotlin_realm.ui.screen.auth.IdentifyFragment
import io.gudnam.kotlin_realm.ui.view.IdentifyView

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
class IdentifyFragmentModule(fragment: IdentifyFragment) : FragmentModule(fragment) {

    @Provides @FragmentScope
    fun provideIdentifyView(): IdentifyView = fragment as IdentifyView

    @Provides @FragmentScope
    fun provideIdentifyPresenter(view: IdentifyView,
                                 bus: Bus,
                                 accessTokenInteractor: GetAccessTokenInteractor,
                                 interactorExecutor: InteractorExecutor)
            = IdentifyPresenter(view, bus, accessTokenInteractor, interactorExecutor)
}