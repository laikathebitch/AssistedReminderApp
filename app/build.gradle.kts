
plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = sdk.compile

    defaultConfig {
        applicationId = "com.bizarre.assistedreminderapp"

        minSdk = sdk.min
        targetSdk = sdk.target
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
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core-database"))
    implementation(project(":core-data"))
    implementation(project(":core-domain"))

    implementation(androidx.core.ktx)
    implementation(androidx.compose.ui.ui)
    implementation(androidx.compose.material)
    implementation(androidx.compose.material_icons)
    implementation(androidx.compose.ui.preview)
    implementation(androidx.lifecycle.compose)
    implementation(androidx.navigation.compose)
    implementation(androidx.lifecycle.runtime)
    implementation(androidx.constraintlayout.compose)

    implementation(androidx.navigation.hilt.compose)



    // Maps dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.0")
    implementation("com.google.maps.android:maps-ktx:3.3.0")
    implementation("com.google.maps.android:maps-utils-ktx:3.3.0")

    implementation("com.google.maps.android:android-maps-utils:2.2.3")
    implementation ("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.gms:play-services-maps:18.1.0")
    implementation("com.google.android.gms:play-services-location:18.0.0")
    implementation("io.coil-kt:coil-compose:2.2.0")
    implementation("androidx.activity:activity-ktx:$1.7.0")
    // Hilt for DI
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
//For rememberLauncherForActivityResult()
    implementation ("androidx.activity:activity-compose:1.6.1")
    implementation ("androidx.appcompat:appcompat:1.1.0-alpha04")
//For PickVisualMedia contract
    implementation ("androidx.activity:activity-ktx:1.6.1")
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation ("androidx.hilt:hilt-work:1.0.0")

    implementation("androidx.work:work-runtime-ktx:2.5.0")
    implementation ("androidx.work:work-runtime:2.3.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.1.1")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.1.1")
    //implementation ("androidx.core:core:$core_version")
    implementation ("androidx.work:work-runtime-ktx:2.7.0")
    implementation ("androidx.hilt:hilt-work:1.0.0")

    // When using Kotlin.
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    // When using Java.
    annotationProcessor("androidx.hilt:hilt-compiler:1.0.0")
    testImplementation("junit:junit:4.13.2")


}

kapt {
    correctErrorTypes = true
}