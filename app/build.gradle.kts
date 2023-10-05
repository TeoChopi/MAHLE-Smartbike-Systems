plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
}

android {
    namespace = "com.mahle.smartbikesystems"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mahle.smartbikesystems"
        minSdk = 24
        targetSdk = 34

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
        debug {
            isDebuggable = true
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
        viewBinding = true
        buildConfig = true
    }

    flavorDimensions += listOf("environment", "version")

    productFlavors {
        create("demo") {
            dimension = "version"
            versionCode = 1
            versionName = "1.0"
            applicationIdSuffix = ".demo"
            versionNameSuffix = "-demo"
        }
        create("full") {
            dimension = "version"
            versionCode = 1
            versionName = "1.0"
        }
        create("dev") {
            dimension = "environment"
            buildConfigField("String", "URL_BASE", "\"https://gateway.marvel.com/\"")
            buildConfigField("String", "PUBLIC_KEY", "\"8c4fa7cc2f3f2560992139693752d43c\"")
            buildConfigField("String", "PRIVATE_KEY", "\"d6deaac229107d222a81590b1b75a81caef59f9d\"")
        }
        create("pro") {
            dimension = "environment"
            buildConfigField("String", "URL_BASE", "\"https://gateway.marvel.com/\"")
            buildConfigField("String", "PUBLIC_KEY", "\"8c4fa7cc2f3f2560992139693752d43c\"")
            buildConfigField("String", "PRIVATE_KEY", "\"d6deaac229107d222a81590b1b75a81caef59f9d\"")
        }
    }
}

dependencies {

    // Android
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.3")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.2.2")

    // Utils
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("com.soywiz.korlibs.krypto:krypto:4.0.2")

    // Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

kapt {
    correctErrorTypes = true
}