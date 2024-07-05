import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlinx.rpc)
  alias(libs.plugins.ksp)
  alias(libs.plugins.kotlinPluginSerialization)
}

kotlin {

  // TODO: Add back wasm after https://github.com/Kotlin/kotlinx-rpc/issues/95
  js {
    browser {
      commonWebpackConfig {
        devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
          static = (static ?: mutableListOf()).apply {
            // Serve sources to debug inside browser
            add(project.projectDir.path)
          }
        }
      }
    }
  }

  androidTarget {

  }

  iosX64()
  iosArm64()
  iosSimulatorArm64()

  jvm()

  sourceSets {
    commonMain.dependencies {
      api(libs.kotlinx.coroutines.core)

      implementation(libs.kotlinx.rpc.runtime)
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.uuid)
    }

    commonTest.dependencies {
      implementation(kotlin("test"))
    }
  }
}

android {
  namespace = "io.github.xxfast.chess.shared"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }

  // TODO: Use kotlin compose compiler
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.14"
  }
}
