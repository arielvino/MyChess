package com.av.mychess.Interfaces.ModelInterfaces;

import com.av.mychess.CommonStructs.PlayerColor;

import java.util.List;

public interface IChessPlayer {
    IChessGame getGame();

    List<IChessPiece> getPieces();

    /**
     * This method indicates whether the given cell is threatened by this player.
     * @param cell the cell you want to check.
     * @return true if the cell is threatened by the player.
     */
    boolean isThreatening(IChessCell cell);

    PlayerColor getColor();
}
