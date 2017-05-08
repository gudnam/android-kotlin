package io.gudnam.kotlin_di.di

import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_di.domain.repository.UserInfoRepository
import io.gudnam.kotlin_di.repository.UserInfoRepositoryImpl
import javax.inject.Singleton

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
class RepositoryModule {

    @Provides @Singleton
    fun provideUserInfoRepo() : UserInfoRepository
            = UserInfoRepositoryImpl()
}