// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.dagger.hilt) apply false
}

buildscript{
    dependencies{
        classpath("com.android.tools.build:gradle:8.1.0") // или другая версия Gradle
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.21") // или другая версия Kotlin
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44") // или другая версия Hilt
    }
}