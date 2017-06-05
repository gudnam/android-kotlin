package io.gudnam.kotlin_realm.di

import android.content.Context
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_realm.di.scope.ActivityScope

/**
 * Created by gudnam on 2017. 4. 27..
 */
@Module
abstract class ActivityModule(protected val activity: AppCompatActivity) {

    @Provides @ActivityScope
    fun provideActivity(): AppCompatActivity = activity

    @Provides @ActivityScope
    fun provideActivityContext(): Context = activity.baseContext
}