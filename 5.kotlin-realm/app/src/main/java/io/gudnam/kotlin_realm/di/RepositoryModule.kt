package io.gudnam.kotlin_realm.di

import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_realm.data.CloudAuthDataSet
import io.gudnam.kotlin_realm.data.api.APIService
import io.gudnam.kotlin_realm.domain.repository.AuthRepository
import io.gudnam.kotlin_realm.domain.repository.UserRepository
import io.gudnam.kotlin_realm.data.repository.AuthRepositoryImpl
import io.gudnam.kotlin_realm.data.repository.UserRepositoryImpl
import javax.inject.Singleton

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
class RepositoryModule {

    @Provides @Singleton
    fun provideAuthRepo(apiService: APIService): AuthRepository
            = AuthRepositoryImpl(CloudAuthDataSet(apiService))

    @Provides @Singleton
    fun provideUserInfoRepo(apiService: APIService) : UserRepository
            = UserRepositoryImpl()
}