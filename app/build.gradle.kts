import com.epilepticcat.buildsrc.Dependencies
import com.epilepticcat.buildsrc.Versions
import com.epilepticcat.buildsrc.BuildConfig

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = BuildConfig.appName
    compileSdk = BuildConfig.compileSdkVersion

    defaultConfig {
        applicationId = BuildConfig.appName
        minSdk = BuildConfig.minSdkVersion
        targetSdk = BuildConfig.targetSdkVersion
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    with(Dependencies) {

        implementation(coreKtx)
        implementation(lifecycleKtx)

        implementation(composeUi)
        implementation(composeUiToolingPreview)
        implementation(composeMaterial3)
        implementation(activityCompose)

        debugImplementation(composeUiTooling)
        debugImplementation(composeUiTest)

        testImplementation(junit)
        androidTestImplementation(composeUiTestJunit)
        androidTestImplementation(androidJunit)
        androidTestImplementation(espresso)
    }
}