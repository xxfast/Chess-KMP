package io.github.xxfast.chess.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

abstract class ViewModel: CoroutineScope {
  override val coroutineContext: CoroutineContext = Dispatchers.UI
}
