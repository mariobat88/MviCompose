package com.example.details.di

import android.content.Context
import com.appslabs.framework.viewmodel.ViewModelComponent
import com.example.details.RunsViewModel
import dagger.Component
import dagger.hilt.android.EntryPointAccessors

@Component(dependencies = [RunsDependencies::class])
interface RunsComponent : ViewModelComponent<RunsViewModel> {

    @Component.Factory
    interface Factory {
        fun create(
            runsDependencies: RunsDependencies
        ): RunsComponent
    }

    companion object {
        operator fun invoke(applicationContext: Context): RunsComponent {
            return DaggerRunsComponent.factory().create(
                runsDependencies = EntryPointAccessors.fromApplication(
                    applicationContext,
                    RunsDependencies::class.java
                )
            )
        }
    }
}
