package com.example.sampleapp.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.sampleapp.BuildConfig
import com.example.sampleapp.SampleApp
import com.example.sampleapp.data.local.DatabaseService
import com.example.sampleapp.data.remote.Networking
import com.example.sampleapp.data.remote.NetworkService
import com.example.sampleapp.di.ApplicationContext
import com.example.sampleapp.utils.network.NetworkHelper
import com.example.sampleapp.utils.rx.RxSchedulerProvider
import com.example.sampleapp.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val applicationMy: SampleApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application = applicationMy

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = applicationMy

    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
            applicationMy.getSharedPreferences("bootcamp-instagram-project-prefs", Context.MODE_PRIVATE)

    /**
     * We need to write @Singleton on the provide method if we are create the instance inside this method
     * to make it singleton. Even if we have written @Singleton on the instance's class
     */
    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService =
            Room.databaseBuilder(
                    applicationMy, DatabaseService::class.java,
                    "bootcamp-instagram-project-db"
            ).build()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
            Networking.create(
                    BuildConfig.API_KEY,
                    BuildConfig.BASE_URL,
                    applicationMy.cacheDir,
                    10 * 1024 * 1024 // 10MB
            )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(applicationMy)
}