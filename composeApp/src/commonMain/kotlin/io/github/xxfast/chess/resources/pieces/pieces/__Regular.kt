package io.github.xxfast.chess.resources.pieces.pieces

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.xxfast.chess.resources.pieces.Pieces
import io.github.xxfast.chess.resources.pieces.pieces.regular.Bb
import io.github.xxfast.chess.resources.pieces.pieces.regular.Bk
import io.github.xxfast.chess.resources.pieces.pieces.regular.Bn
import io.github.xxfast.chess.resources.pieces.pieces.regular.Bp
import io.github.xxfast.chess.resources.pieces.pieces.regular.Bq
import io.github.xxfast.chess.resources.pieces.pieces.regular.Br
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wb
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wk
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wn
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wp
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wq
import io.github.xxfast.chess.resources.pieces.pieces.regular.Wr
import kotlin.collections.List as ____KtList

public object RegularGroup

public val Pieces.Regular: RegularGroup
  get() = RegularGroup

private var __Pieces: ____KtList<ImageVector>? = null

public val RegularGroup.Pieces: ____KtList<ImageVector>
  @Composable get() {
    if (__Pieces != null) {
      return __Pieces!!
    }
    __Pieces= listOf(Bn, Wn, Bk, Wk, Bp, Wq, Wp, Bq, Wr, Br, Bb, Wb)
    return __Pieces!!
  }
