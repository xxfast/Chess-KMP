package io.github.xxfast.chess

import io.github.xxfast.kstore.file.utils.FILE_SYSTEM
import net.harawata.appdirs.AppDirsFactory
import okio.Path.Companion.toPath

actual class PlatformScope {
  val userDataDir: String = AppDirsFactory.getInstance()
    .getUserDataDir("io.github.xxfast.chess", "1.0", "xxfast")
    .also { FILE_SYSTEM.createDirectories(it.toPath()) }
}