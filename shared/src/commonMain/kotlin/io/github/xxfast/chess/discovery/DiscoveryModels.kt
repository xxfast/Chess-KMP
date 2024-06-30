package io.github.xxfast.chess.discovery

import com.benasher44.uuid.uuid4
import io.github.xxfast.chess.game.Game
import io.github.xxfast.chess.game.PieceColor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline
import kotlin.random.Random

val Loading = null
val None = null

@Serializable
data class Player(
  val id: String = uuid4().toString(),
  val elo: Int = 200,
  val name: String = "player-${Random.nextInt(1000)}",
)

@Serializable
data class Invite(
  val from: Player,
  val to: Player,
  val status: InviteStatus,
)

enum class InviteStatus {
  SENT,
  ACCEPTED,
  REJECTED,
}

@Serializable
data class Match(
  val id: String = uuid4().toString(),
  val players: Map<PieceColor, Player>,
  val game: Game,
)

@Serializable
sealed class DiscoveryEvent {
  @Serializable
  data class Send(val from: Player, val to: Player) : DiscoveryEvent()
  @Serializable
  data class Decline(val invite: Invite) : DiscoveryEvent()
  @Serializable
  data class Accept(val invite: Invite) : DiscoveryEvent()
  @Serializable
  data class Withdraw(val invite: Invite) : DiscoveryEvent()
}

@Serializable
data class DiscoveryState(
  val players: List<Player>? = Loading,
  val invites: Set<Invite>? = Loading,
  val matches: Set<Match>? = None
)

@Serializable
@JvmInline
value class Address(val value: String) : CharSequence by value {
  constructor(host: String, port: Int) : this("$host:$port")

  val host: String get() = value.substringBefore(":")
  val port: Int get() = value.substringAfter(":").toInt()
}