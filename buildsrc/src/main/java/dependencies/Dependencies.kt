@file:Suppress("unused", "ClassName", "MemberVisibilityCanPrivate")

package dependencies

object app {
    val applicationId = "com.example.myapplication"
}

object versions {
    val buildTools = "28.0.3"

    val compileSdk = 30
    val minSdk = 21
    val targetSdk = compileSdk

    val compose = "1.0.0-alpha08"
    val composeTooling = "1.0.0-alpha07"
    val composeNavigation = "1.0.0-alpha03"
    val gradle = "4.2.0-beta01"
    val hilt = "2.28-alpha"
    val hiltViewModel = "1.0.0-alpha02"
    val kotlin = "1.4.20"
    val material = "1.2.1"
}

object plugin {
    object android {
        val gradle = "com.android.tools.build:gradle:${versions.gradle}"
        val hilt = "com.google.dagger:hilt-android-gradle-plugin:${versions.hilt}"
    }

    object kotlin {
        val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}"
    }
}

object deps {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${versions.kotlin}"

    object android {
        val material = "com.google.android.material:material:${versions.material}"
    }

    object compose {
        val ui = "androidx.compose.ui:ui:${versions.compose}"
        val tooling = "androidx.ui:ui-tooling:${versions.composeTooling}"
        val foundation = "androidx.compose.foundation:foundation:${versions.compose}"
        val material = "androidx.compose.material:material:${versions.compose}"
        val materialIconsCore = "androidx.compose.material:material-icons-core:${versions.compose}"
        val materialIconsCoreExt =
            "androidx.compose.material:material-icons-extended:${versions.compose}"
        val navigation = "androidx.navigation:navigation-compose:${versions.composeNavigation}"
    }

    object hilt {
        val core = "com.google.dagger:hilt-android:${versions.hilt}}"
        val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${versions.hiltViewModel}}"

    }
}
