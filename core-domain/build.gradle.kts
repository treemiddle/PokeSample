plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    kotlin("kapt")
}

android {
    compileSdk = com.treemiddle.buildsrc.AndroidConfiguration.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = com.treemiddle.buildsrc.AndroidConfiguration.MIN_SDK_VERSION
        targetSdk = com.treemiddle.buildsrc.AndroidConfiguration.TARGET_SDK_VERSION
    }
}

dependencies {
    implementation(project(":core-model"))
    implementation(project(":core-data"))

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.comipler)
}
