package io.github.xxfast.chess.utils

import io.github.xxfast.chess.ChessApplicationScope
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import okio.Path.Companion.toPath

actual inline fun <reified T : Any> ChessApplicationScope.storeOf(
  name: String,
  default: T,
): KStore<T> =
  storeOf(
    file = "${platform.documentDir}/$name.json".toPath(),
    default = default,
    json = json
  )
