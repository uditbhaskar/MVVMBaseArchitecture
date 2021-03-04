package com.example.sampleapp

import android.app.Application
import com.example.sampleapp.di.component.ApplicationComponent
import com.example.sampleapp.di.component.DaggerApplicationComponent
import com.example.sampleapp.di.module.ApplicationModule

class SampleApp : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}