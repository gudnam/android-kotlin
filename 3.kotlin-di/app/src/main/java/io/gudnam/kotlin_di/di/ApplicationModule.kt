package io.gudnam.kotlin_di.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_di.App
import io.gudnam.kotlin_di.di.qualifier.ApplicationQualifier
import javax.inject.Singleton

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
class ApplicationModule(private val app: App) {

    @Provides @Singleton
    fun provideApplication(): App = app

    @Provides @Singleton @ApplicationQualifier
    fun provideApplicationContext(): Context = app
}