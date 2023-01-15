plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    kotlin("kapt")
}

android {
    compileSdk = com.treemiddle.buildsrc.AndroidConfiguration.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = com.treemiddle.buildsrc.AndroidConfiguration.MIN_SDK_VERSION
        targetSdk = com.treemiddle.buildsrc.AndroidConfiguration.TARGET_SDK_VERSION
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
}

dependencies {
    implementation(project(":core-domain"))

    // androidx
    implementation(libs.compose.material)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // compose
    implementation(libs.compose.ui)

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.comipler)
}
