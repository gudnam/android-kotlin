package io.gudnam.kotlin_retrofit.di

import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_retrofit.domain.interactor.FindUserInfoInteractor
import io.gudnam.kotlin_retrofit.domain.interactor.GetAuthNumberInteractor
import io.gudnam.kotlin_retrofit.domain.repository.AuthRepository
import io.gudnam.kotlin_retrofit.domain.repository.UserRepository

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
class DomainModule {

    @Provides
    fun provideAuthInteractor(authRepository: AuthRepository)
            = GetAuthNumberInteractor(authRepository)

    @Provides
    fun provideUserInfoInteractor(userRepository: UserRepository)
            = FindUserInfoInteractor()
}