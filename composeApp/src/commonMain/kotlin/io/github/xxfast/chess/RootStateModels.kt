package io.github.xxfast.chess

import io.github.xxfast.chess.discovery.MatchId
import kotlinx.serialization.Serializable

@Serializable
sealed class RootScreens {
  @Serializable data object MatchMaking : RootScreens()
  @Serializable data object Settings : RootScreens()
  @Serializable data class Match(val match: MatchId) : RootScreens()
}
