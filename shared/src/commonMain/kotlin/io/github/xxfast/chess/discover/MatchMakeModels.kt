package io.github.xxfast.chess.discover

import kotlinx.serialization.Serializable

@Serializable
data class Player(
  val id: String,
  val elo: Int,
  val name: String,
)

@Serializable
data class Match(
  val white: Player,
  val black: Player,
)


