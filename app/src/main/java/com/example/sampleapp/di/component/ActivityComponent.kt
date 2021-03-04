package com.example.sampleapp.di.component

import com.example.sampleapp.di.ActivityScope
import com.example.sampleapp.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

}