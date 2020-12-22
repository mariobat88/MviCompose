@file:Suppress("unused", "ClassName", "MemberVisibilityCanPrivate")

package dependencies

object app {
    const val applicationId = "com.example.myapplication"
    const val buildTools = "28.0.3"

    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = compileSdk
}

object versions {
    const val appcompat = "1.2.0"
    const val coil = "1.1.0"
    const val compose = "1.0.0-alpha09"
    const val composeTooling = "1.0.0-alpha07"
    const val composeNavigation = "1.0.0-alpha03"
    const val coroutines = "1.4.2"
    const val gradle = "4.2.0-beta02"
    const val hilt = "2.28-alpha"
    const val hiltViewModel = "1.0.0-alpha02"
    const val kotlin = "1.4.21"
    const val material = "1.2.1"
    const val moshi = "1.11.0"
    const val retrofit = "2.9.0"
    const val retrofitInterceptor = "4.9.0"
}

object plugin {
    object android {
        const val gradle = "com.android.tools.build:gradle:${versions.gradle}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${versions.hilt}"
    }

    object kotlin {
        const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}"
    }
}

object deps {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${versions.kotlin}"

    object android {
        const val appcompat = "androidx.appcompat:appcompat:${versions.appcompat}"
        const val material = "com.google.android.material:material:${versions.material}"
    }

    object coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${versions.coroutines}"
    }

    object compose {
        const val ui = "androidx.compose.ui:ui:${versions.compose}"
        const val tooling = "androidx.ui:ui-tooling:${versions.composeTooling}"
        const val foundation = "androidx.compose.foundation:foundation:${versions.compose}"
        const val material = "androidx.compose.material:material:${versions.compose}"
        const val materialIconsCore = "androidx.compose.material:material-icons-core:${versions.compose}"
        const val materialIconsCoreExt =
            "androidx.compose.material:material-icons-extended:${versions.compose}"
        const val navigation = "androidx.navigation:navigation-compose:${versions.composeNavigation}"
    }

    object coil {
        const val core = "io.coil-kt:coil:${versions.coil}"
    }

    object hilt {
        const val core = "com.google.dagger:hilt-android:${versions.hilt}}"
        const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${versions.hiltViewModel}}"
    }

    object retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${versions.retrofit}"
        const val logging = "com.squareup.okhttp3:logging-interceptor:${versions.retrofitInterceptor}"
        const val moshi = "com.squareup.retrofit2:converter-moshi:${versions.retrofit}"
    }

    object moshi {
        const val core = "com.squareup.moshi:moshi:${versions.moshi}"
        const val compiler = "com.squareup.moshi:moshi-kotlin-codegen:${versions.moshi}"
    }
}
