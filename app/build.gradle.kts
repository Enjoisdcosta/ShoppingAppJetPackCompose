plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)


    //hilt
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.shoppingappjetpackcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.shoppingappjetpackcompose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.junit.jupiter)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    //GSON helps with the serialization of data
    implementation (libs.gson)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.dagger.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //okhttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    implementation (libs.coil.compose)

    //top bar dependency
    implementation (libs.androidx.material)

    //testing dependencies
    // Unit testing
    testImplementation (libs.junit)
    testImplementation (libs.kotlinx.coroutines.test)
    testImplementation (libs.mockito.core)
    testImplementation (libs.mockito.kotlin)
    testImplementation (libs.kotlin.test.junit)

    //new test
    testImplementation (libs.mockk)
    testImplementation (libs.kotlinx.coroutines.test.v152)

    // For running instrumented tests
    androidTestImplementation (libs.androidx.junit.v113)
    androidTestImplementation (libs.androidx.espresso.core.v340)



    // Compose UI testing
    androidTestImplementation (libs.ui.test.junit4)
    debugImplementation (libs.ui.test.manifest)

    // Hilt testing
    androidTestImplementation (libs.hilt.android.testing)
    kaptAndroidTest (libs.hilt.compiler.v2381)

    // Espresso
    androidTestImplementation (libs.androidx.espresso.core.v340)
    androidTestImplementation (libs.androidx.junit.v113)

    // Navigation testing
    androidTestImplementation (libs.androidx.navigation.testing)






}