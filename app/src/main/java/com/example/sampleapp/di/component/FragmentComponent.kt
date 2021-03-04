package com.example.sampleapp.di.component

import com.example.sampleapp.di.FragmentScope
import com.example.sampleapp.di.module.FragmentModule
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {


}