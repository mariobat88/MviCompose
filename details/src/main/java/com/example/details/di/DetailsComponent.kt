package com.example.details.di

import android.content.Context
import com.appslabs.framework.viewmodel.ViewModelComponent
import com.example.details.DetailsViewModel
import dagger.Component
import dagger.hilt.android.EntryPointAccessors

@Component(dependencies = [DetailsModuleDependencies::class])
interface DetailsComponent : ViewModelComponent<DetailsViewModel> {

    @Component.Factory
    interface Factory {
        fun create(
            detailsModuleDependencies: DetailsModuleDependencies
        ): DetailsComponent
    }

    companion object {
        operator fun invoke(applicationContext: Context): DetailsComponent {
            return DaggerDetailsComponent.factory().create(
                detailsModuleDependencies = EntryPointAccessors.fromApplication(
                    applicationContext,
                    DetailsModuleDependencies::class.java
                )
            )
        }
    }

}