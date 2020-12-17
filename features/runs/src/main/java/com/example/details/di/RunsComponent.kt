package com.example.details.di

import android.content.Context
import com.appslabs.framework.viewmodel.ViewModelComponent
import com.example.details.RunsViewModel
import dagger.Component
import dagger.hilt.android.EntryPointAccessors

@Component(dependencies = [RunsModuleDependencies::class])
interface RunsComponent : ViewModelComponent<RunsViewModel> {

    @Component.Factory
    interface Factory {
        fun create(
            runsModuleDependencies: RunsModuleDependencies
        ): RunsComponent
    }

    companion object {
        operator fun invoke(applicationContext: Context): RunsComponent {
            return DaggerRunsComponent.factory().create(
                runsModuleDependencies = EntryPointAccessors.fromApplication(
                    applicationContext,
                    RunsModuleDependencies::class.java
                )
            )
        }
    }

}