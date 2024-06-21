package io.github.xxfast.chess.utils

import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.kstore.KStore

expect inline fun <reified T : Any> ChessApplicationScope.storeOf(
  name: String, default: T
): KStore<T>