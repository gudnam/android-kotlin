package io.gudnam.kotlin_realm.di

import android.content.Context
import io.gudnam.kotlin_realm.domain.BusImpl
import io.gudnam.kotlin_realm.domain.interactor.base.Bus
import io.gudnam.kotlin_realm.domain.interactor.base.CustomJobManager
import io.gudnam.kotlin_realm.domain.interactor.base.InteractorExecutor
import io.gudnam.kotlin_realm.domain.interactor.base.InteractorExecutorImpl
import com.birbit.android.jobqueue.JobManager
import dagger.Module
import dagger.Provides
import io.gudnam.kotlin_realm.App
import io.gudnam.kotlin_realm.di.qualifier.ApplicationQualifier
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

    @Provides @Singleton
    fun provideBus(): Bus = BusImpl()

    @Provides @Singleton
    fun provideJobManager(@ApplicationQualifier context: Context): JobManager = CustomJobManager(context)

    @Provides @Singleton
    fun provideInteractorExecutor(jobManager: JobManager, bus: Bus): InteractorExecutor = InteractorExecutorImpl(jobManager, bus)
}