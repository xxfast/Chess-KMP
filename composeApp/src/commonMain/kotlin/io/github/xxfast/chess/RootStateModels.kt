package io.github.xxfast.chess

import io.github.xxfast.chess.discovery.Match
import kotlinx.serialization.Serializable

@Serializable
sealed class RootScreens {
  @Serializable data object MatchMaking : RootScreens()
  @Serializable data object Settings : RootScreens()
  @Serializable data class Game(val match: Match) : RootScreens()
}
