plugins {
  alias(libs.plugins.kotlinJvm)
  alias(libs.plugins.kotlinPluginSerialization)
  alias(libs.plugins.ktor)
  alias(libs.plugins.kotlinx.rpc.platform)
  alias(libs.plugins.molecule)

  application
}

group = "io.github.xxfast.chess"
version = "1.0.0"

application {
  mainClass.set("io.github.xxfast.chess.ApplicationKt")

  applicationDefaultJvmArgs =
    listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
  implementation(libs.kotlinx.datetime)
  implementation(libs.kotlinx.rpc.runtime.serialization.json)
  implementation(libs.kotlinx.rpc.transport.ktor.server)
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.ktor.server.cio)
  implementation(libs.ktor.server.core)
  implementation(libs.ktor.server.core.jvm)
  implementation(libs.ktor.server.netty)
  implementation(libs.ktor.server.websockets.jvm)
  implementation(libs.logback)
  implementation(projects.shared)

  testImplementation(libs.kotlin.test.junit)
  testImplementation(libs.ktor.server.tests)
}
