package io.gudnam.kotlin_di

import android.app.Application
import io.gudnam.kotlin_di.di.ApplicationComponent
import io.gudnam.kotlin_di.di.ApplicationModule
import io.gudnam.kotlin_di.di.DaggerApplicationComponent

/**
 * Created by gudnam on 2017. 3. 21..
 */
class App : Application() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}