package io.github.xxfast.chess.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlin.coroutines.CoroutineContext

actual val Dispatchers.IO: CoroutineContext get() = Dispatchers.IO

actual val Dispatchers.UI: CoroutineContext get() = Main
