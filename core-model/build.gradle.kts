import com.treemiddle.buildsrc.AndroidConfiguration

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = AndroidConfiguration.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AndroidConfiguration.MIN_SDK_VERSION
        targetSdk = AndroidConfiguration.TARGET_SDK_VERSION
    }
}
