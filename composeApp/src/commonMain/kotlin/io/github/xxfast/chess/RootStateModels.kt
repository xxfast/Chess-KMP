package io.github.xxfast.chess

import kotlinx.serialization.Serializable

@Serializable
sealed class RootScreens {
  @Serializable data object MatchMaking : RootScreens()
  @Serializable data object Settings : RootScreens()
  @Serializable data object Game : RootScreens()
}
