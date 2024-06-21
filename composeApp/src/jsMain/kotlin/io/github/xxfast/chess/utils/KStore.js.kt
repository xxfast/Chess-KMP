package io.github.xxfast.chess.utils

import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.kstore.KStore

actual inline fun <reified T: Any> ChessApplicationScope.storeOf(
  name: String,
  default: T,
) : KStore<T> = io.github.xxfast.kstore.storage.storeOf(name, default)