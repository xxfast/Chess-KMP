package io.github.xxfast.chess.discovery

import com.benasher44.uuid.uuid4
import io.github.xxfast.chess.game.Game
import io.github.xxfast.chess.game.Piece
import io.github.xxfast.chess.game.PieceColor
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline
import kotlin.random.Random
import kotlin.time.Duration

val Loading = null
val None = null

@Serializable
data class Player(
  val id: String = uuid4().toString(),
  val elo: Int = 200,
  val name: String = "player-${Random.nextInt(1000)}",
  val piece: Piece = Piece.WhitePawn,
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
@JvmInline
value class MatchId(val value: String = uuid4().toString()): CharSequence by value

@Serializable
data class Match(
  val id: MatchId = MatchId(),
  val scores: List<PlayerScore>,
  val game: Game = Game(),
  val startedAt: Instant = Clock.System.now(),
)

@Serializable
data class PlayerScore(
  val player: Player,
  val color: PieceColor,
  val score: Int,
  val time: Duration
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