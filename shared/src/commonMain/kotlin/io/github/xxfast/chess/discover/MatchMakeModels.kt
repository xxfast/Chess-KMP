package io.github.xxfast.chess.discover

import com.benasher44.uuid.uuid4
import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class Player(
  val id: String = uuid4().toString(),
  val elo: Int = 200,
  val name: String = "player-${Random.nextInt(1000)}",
)

@Serializable
data class Match(
  val white: Player,
  val black: Player,
)


