package io.github.xxfast.chess

import io.github.xxfast.kstore.file.utils.DocumentDirectory
import io.github.xxfast.kstore.utils.ExperimentalKStoreApi
import platform.Foundation.NSFileManager

actual class PlatformScope {
  @OptIn(ExperimentalKStoreApi::class)
  val documentDir = NSFileManager.defaultManager.DocumentDirectory?.relativePath
}
