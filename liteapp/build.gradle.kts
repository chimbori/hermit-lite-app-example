import org.gradle.api.JavaVersion.VERSION_17

plugins {
  id("com.android.application")
  id("kotlin-android")
}

android {
  namespace = "org.example.liteapp"
  compileSdk = libs.versions.compileSdk.get().toInt()

  buildFeatures {
    buildConfig = true
  }
  defaultConfig {
    applicationId = "org.example.liteapp"
    minSdk = libs.versions.minSdk.get().toInt()
    targetSdk = libs.versions.targetSdk.get().toInt()

    resValue("string", "start_url", "https://example.org/")
    resValue("string", "app_name", "Example Simple")

    // testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"

  }

  kotlinOptions {
    jvmTarget = "17"
  }
  compileOptions {
    sourceCompatibility = VERSION_17
    targetCompatibility = VERSION_17
  }
}

dependencies {
  implementation("androidx.annotation:annotation:1.2.0")

  // implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"

  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
  androidTestImplementation("androidx.test:core:1.4.0")
  androidTestImplementation("androidx.test:runner:1.4.0")
  androidTestImplementation("androidx.test:rules:1.4.0")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
}
