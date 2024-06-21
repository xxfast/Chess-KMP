package io.github.xxfast.chess.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val Dispatchers.UI: CoroutineContext get() = Main
actual val Dispatchers.IO: CoroutineContext get() = Dispatchers.IO
