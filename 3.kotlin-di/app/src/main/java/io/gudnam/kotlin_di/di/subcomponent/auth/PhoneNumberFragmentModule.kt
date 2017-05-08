package io.gudnam.kotlin_di.di.subcomponent.auth

import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_di.di.FragmentModule
import io.gudnam.kotlin_di.di.scope.FragmentScope
import io.gudnam.kotlin_di.domain.interactor.FindUserInfoInteractor
import io.gudnam.kotlin_di.ui.presenter.PhoneNumberPresenter
import io.gudnam.kotlin_di.ui.screen.auth.PhoneNumberFragment
import io.gudnam.kotlin_di.ui.view.PhoneNumberView

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
class PhoneNumberFragmentModule(fragment: PhoneNumberFragment) : FragmentModule(fragment) {

    @Provides @FragmentScope
    fun providePhoneNumberView(): PhoneNumberView = fragment as PhoneNumberView

    @Provides @FragmentScope
    fun providePhoneNumberPresenter(view: PhoneNumberView,
                                    userInfoInteractor: FindUserInfoInteractor) = PhoneNumberPresenter(view, userInfoInteractor)
}