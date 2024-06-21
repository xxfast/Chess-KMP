package io.github.xxfast.chess.utils

import app.cash.molecule.AndroidUiDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val Dispatchers.UI: CoroutineContext get() = AndroidUiDispatcher.Main
actual val Dispatchers.IO: CoroutineContext get() = Dispatchers.IO
