package io.gudnam.kotlin_realm.di.subcomponent.auth

import io.gudnam.kotlin_realm.domain.interactor.base.Bus
import io.gudnam.kotlin_realm.domain.interactor.base.InteractorExecutor
import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_realm.di.FragmentModule
import io.gudnam.kotlin_realm.di.scope.FragmentScope
import io.gudnam.kotlin_realm.domain.interactor.GetAuthNumberInteractor
import io.gudnam.kotlin_realm.ui.entity.mapper.AuthDetailDataMapper
import io.gudnam.kotlin_realm.ui.presenter.PhoneNumberPresenter
import io.gudnam.kotlin_realm.ui.screen.auth.PhoneNumberFragment
import io.gudnam.kotlin_realm.ui.view.PhoneNumberView

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
class PhoneNumberFragmentModule(fragment: PhoneNumberFragment) : FragmentModule(fragment) {

    @Provides @FragmentScope
    fun providePhoneNumberView(): PhoneNumberView = fragment as PhoneNumberView

    @Provides @FragmentScope
    fun providePhoneNumberDataMapper() = AuthDetailDataMapper()

    @Provides @FragmentScope
    fun providePhoneNumberPresenter(view: PhoneNumberView,
                                    bus: Bus,
                                    authNumberInteractor: GetAuthNumberInteractor,
                                    interactorExecutor: InteractorExecutor,
                                    authDetailDataMapper: AuthDetailDataMapper)
            = PhoneNumberPresenter(view, bus, authNumberInteractor, interactorExecutor, authDetailDataMapper)
}