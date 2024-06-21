package io.github.xxfast.chess.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

expect val Dispatchers.UI: CoroutineContext

expect val Dispatchers.IO: CoroutineContext
