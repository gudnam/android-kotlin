package io.gudnam.kotlin_retrofit.di

import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_retrofit.data.CloudAuthDataSet
import io.gudnam.kotlin_retrofit.data.api.APIService
import io.gudnam.kotlin_retrofit.domain.repository.AuthRepository
import io.gudnam.kotlin_retrofit.domain.repository.UserRepository
import io.gudnam.kotlin_retrofit.repository.AuthRepositoryImpl
import io.gudnam.kotlin_retrofit.repository.UserRepositoryImpl
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