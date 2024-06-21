package io.github.xxfast.chess.utils

expect object Device {
  val name: String
  val model: String?
}

expect object OperatingSystem {
  val name: String
  val version: String
}
