package com.example.sampleapp.di.component

import com.example.sampleapp.di.ViewModelScope
import com.example.sampleapp.di.module.ViewHolderModule

import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {


}