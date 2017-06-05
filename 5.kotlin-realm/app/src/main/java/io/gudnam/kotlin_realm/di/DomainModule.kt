package io.gudnam.kotlin_realm.di

import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_realm.domain.interactor.GetAccessTokenInteractor
import io.gudnam.kotlin_realm.domain.interactor.GetAuthNumberInteractor
import io.gudnam.kotlin_realm.domain.repository.AuthRepository

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
class DomainModule {

    @Provides
    fun provideAuthInteractor(authRepository: AuthRepository)
            = GetAuthNumberInteractor(authRepository)

    @Provides
    fun provideAccessTokenInteractor(authRepository: AuthRepository)
            = GetAccessTokenInteractor(authRepository)
}