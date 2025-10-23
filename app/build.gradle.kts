plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.simulapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.simulapp"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Gson para processar JSON
    implementation("com.google.code.gson:gson:2.10.1")

    // OkHttp para requisições HTTP
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // Glide para carregar imagens
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // PhotoView para pinch-to-zoom em imagens
    implementation("com.github.chrisbanes:PhotoView:2.3.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}