package io.gudnam.kotlin_di.di

import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_di.domain.interactor.FindUserInfoInteractor
import io.gudnam.kotlin_di.domain.repository.UserInfoRepository

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
class DomainModule {

    @Provides
    fun provideUserInfoInteractor(userInfoRepository: UserInfoRepository)
            = FindUserInfoInteractor()
}