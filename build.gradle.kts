import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath(libs.android.gradle.plugin)
    classpath(libs.kotlin.plugin)
  }
}

allprojects {
  tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
      allWarningsAsErrors = true
    }
  }
  repositories {
    google()
    mavenCentral()
  }
}
