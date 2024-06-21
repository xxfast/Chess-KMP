package io.github.xxfast.chess.utils

import android.os.Build

actual object Device {
  actual val name: String get() = Build.DEVICE
  actual val model: String? get() = Build.MODEL
}

actual object OperatingSystem {
  actual val name: String
    get() = Build.VERSION.BASE_OS
  actual val version: String
    get() = Build.VERSION.CODENAME
}
