import com.treemiddle.buildsrc.AndroidConfiguration

plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.kapt.get().pluginId)
    id(libs.plugins.hilt.get().pluginId)
}

android {
    compileSdk = AndroidConfiguration.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AndroidConfiguration.MIN_SDK_VERSION
        targetSdk = AndroidConfiguration.TARGET_SDK_VERSION
    }
}
dependencies {
    api(project(":core-model"))
    implementation(project(":network"))

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.comipler)
}
