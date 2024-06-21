import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.compose.multiplatform)
  alias(libs.plugins.kotlinx.rpc.platform)
  alias(libs.plugins.kotlinPluginSerialization)
}

kotlin {
  // TODO: Add back wasm after https://github.com/Kotlin/kotlinx-rpc/issues/95
  js {
    moduleName = "composeApp"
    browser {
      commonWebpackConfig {
        outputFileName = "composeApp.js"
        devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
          static = (static ?: mutableListOf()).apply {
            // Serve sources to debug inside browser
            add(project.projectDir.path)
          }
        }
      }
    }
    binaries.executable()
  }

  androidTarget {

  }

  jvm("desktop")

  listOf(
    iosX64(),
    iosArm64(),
    iosSimulatorArm64()
  ).forEach { iosTarget ->
    iosTarget.binaries.framework {
      baseName = "ComposeApp"
      isStatic = true

      export(libs.decompose.router)
    }
  }

  sourceSets {
    val desktopMain by getting

    androidMain.dependencies {
      implementation(compose.preview)
      implementation(libs.androidx.activity.compose)
      implementation(libs.google.android.material)
      implementation(libs.kstore.file)
      implementation(libs.ktor.client.okhttp)
    }

    commonMain.dependencies {
      api(libs.decompose.router)

      implementation(projects.shared)

      implementation(compose.runtime)
      implementation(compose.foundation)
      implementation(compose.material3)
      implementation(compose.ui)
      implementation(compose.components.resources)
      implementation(compose.components.uiToolingPreview)

      implementation(libs.compose.dnd)
      implementation(libs.decompose)
      implementation(libs.decompose.compose)
      implementation(libs.kstore)
      implementation(libs.kotlinx.rpc.runtime.serialization.json)
      implementation(libs.kotlinx.rpc.transport.ktor.client)
      implementation(libs.ktor.client.contentnegotiation)
      implementation(libs.ktor.client.core)
      implementation(libs.ktor.client.serialization)
      implementation(libs.ktor.client.logging)
      implementation(libs.ktor.serialization.kotlinx.json)
      implementation(libs.molecule.runtime)
      implementation(libs.uuid)
    }

    desktopMain.dependencies {
      implementation(compose.desktop.currentOs)
      implementation(libs.kstore.file)
      implementation(libs.ktor.client.cio)
      implementation(libs.kotlinx.coroutines.swing)
    }

    iosMain.dependencies {
      implementation(libs.kstore.file)
      implementation(libs.ktor.client.cio)
    }

    jsMain.dependencies {
      implementation(libs.kstore.storage)
      implementation(libs.ktor.client.js)
    }
  }
}

android {
  namespace = "io.github.xxfast.chess"
  compileSdk = libs.versions.android.compileSdk.get().toInt()

  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  sourceSets["main"].res.srcDirs("src/androidMain/res")
  sourceSets["main"].resources.srcDirs("src/commonMain/resources")

  defaultConfig {
    applicationId = "io.github.xxfast.chess"
    minSdk = libs.versions.android.minSdk.get().toInt()
    targetSdk = libs.versions.android.targetSdk.get().toInt()
    versionCode = 1
    versionName = "1.0"
  }

  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      signingConfig = signingConfigs.getByName("debug")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  buildFeatures {
    compose = true
  }

  // TODO: Use kotlin compose compiler
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.14"
  }

  dependencies {
    debugImplementation(compose.uiTooling)
  }
}

compose.desktop {
  application {
    mainClass = "ApplicationKt"

    nativeDistributions {
      targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
      packageName = "io.github.xxfast.chess"
      packageVersion = "1.0.0"
    }
  }
}

compose.experimental {
  web.application { }
}