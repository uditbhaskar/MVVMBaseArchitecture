package com.example.sampleapp.di.module

import androidx.lifecycle.LifecycleRegistry
import com.example.sampleapp.di.ViewModelScope
import com.example.sampleapp.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}