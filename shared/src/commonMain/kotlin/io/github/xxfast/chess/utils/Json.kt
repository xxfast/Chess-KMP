package io.github.xxfast.chess.utils

import kotlinx.serialization.json.Json

val jsonModule: Json = Json {
  ignoreUnknownKeys = true
  encodeDefaults = true
  allowStructuredMapKeys = true
}