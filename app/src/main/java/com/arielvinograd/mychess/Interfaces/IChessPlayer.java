package com.arielvinograd.mychess.Interfaces;

import java.util.List;

public interface IChessPlayer {
    IChessGame getGame();

    List<IChessPiece> getPieces();

    boolean isThreatening(IChessCell cell);

    PlayerColor getColor();
}
