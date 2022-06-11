plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    kotlin("plugin.serialization") version "1.6.10"
}

android {

    compileSdk = Configs.compileSdkVersion
    buildToolsVersion = Configs.buildToolsVersion

    defaultConfig {
        applicationId = "com.cybertaxi.mobile"
        minSdk = Configs.minSdkVersion
        targetSdk = Configs.targetSdkVersion
        versionCode = Configs.versionCode
        versionName = Configs.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions.add("product")
    productFlavors {
        create("passenger") {
            dimension = "product"
            applicationId = "com.cybertaxi.mobile"
        }

        create("driver") {
            dimension = "product"
            applicationId = "com.cybertaxi.driver"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    kapt(ProjectKaptProvider)
    implementation(ProjectDepsProvider)
    testImplementation(ProjectTestDepsProvider)
    androidTestImplementation(ProjectAndroidTestDepsProvider)
    platformImplementation(ProjectPlatformDepsProvider)
    projectImplementation(LocalProjectsProvider)
    implementation(kotlin("reflect"))
}