import com.treemiddle.buildsrc.AndroidConfiguration

plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    kotlin("kapt")
}

android {
    compileSdk = AndroidConfiguration.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AndroidConfiguration.MIN_SDK_VERSION
        targetSdk = AndroidConfiguration.TARGET_SDK_VERSION
    }
}

dependencies {
    implementation(project(":core-data"))

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.comipler)
}
