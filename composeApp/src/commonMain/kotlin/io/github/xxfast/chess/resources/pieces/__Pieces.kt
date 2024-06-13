package io.github.xxfast.chess.resources.pieces

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.xxfast.chess.resources.pieces.pieces.Pieces
import io.github.xxfast.chess.resources.pieces.pieces.Regular
import kotlin.collections.List as ____KtList

public object Pieces

private var __Pieces: ____KtList<ImageVector>? = null

public val Pieces.Pieces: ____KtList<ImageVector>
  @Composable get() {
    if (__Pieces != null) {
      return __Pieces!!
    }
    __Pieces= Regular.Pieces + listOf()
    return __Pieces!!
  }
