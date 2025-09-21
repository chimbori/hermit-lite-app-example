import org.gradle.api.JavaVersion.VERSION_21
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21

plugins {
  id("com.android.application")
  id("kotlin-android")
}

android {
  defaultConfig {
    //-------------------------------------------------------------------------
    // CHANGEME: Use a unique applicationId for your app.
    applicationId = "org.example.liteapp"
    // CHANGEME: Select a URL for Hermit to open.
    resValue("string", "start_url", "https://example.org/")
    // CHANGEME: Select a name for the generated APK.
    resValue("string", "app_name", "Example")
    //-------------------------------------------------------------------------

    // No changes required anywhere else in the source.

    minSdk = libs.versions.minSdk.get().toInt()
    targetSdk = libs.versions.targetSdk.get().toInt()
  }

  namespace = "com.chimbori.liteappstarter"
  compileSdk = libs.versions.compileSdk.get().toInt()

  buildFeatures {
    buildConfig = true
  }
  java {
    toolchain {
      languageVersion = JavaLanguageVersion.of(21)
    }
  }
  kotlin {
    compilerOptions {
      jvmTarget.set(JVM_21)
      freeCompilerArgs.add("-Xannotation-target-all")
    }
  }
  compileOptions {
    sourceCompatibility = VERSION_21
    targetCompatibility = VERSION_21
  }
}
