package io.github.xxfast.chess.utils

actual object Device {
  actual val name: String
    get() = System.getProperty("user.name")
  actual val model: String?
    get() = null
}

actual object OperatingSystem {
  actual val name: String
    get() = System.getProperty("os.name")
  actual val version: String
    get() = System.getProperty("os.version")
}
