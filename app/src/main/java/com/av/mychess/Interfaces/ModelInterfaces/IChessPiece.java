package com.av.mychess.Interfaces.ModelInterfaces;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.CommonStructs.PlayerColor;

import java.util.ArrayList;

public interface IChessPiece extends IChessGame.IOnTurnDoneListener {
    /**
     * This method returns an array of possible turns that this piece can perform in the current state.
     * The list is not filtered yet, so it might contain turns that are illegal in the context of the whole game rules.
     * @return list of unchecked possible turns for this piece.
     */
    ArrayList<ITurnInfo> getUncheckedPossibleTurns();

    ArrayList<Vector2D> getThreatenedLocations();

    String getName();

    IChessCell getCell();

    void setCell(IChessCell cell);

    boolean isFirstMove();

    void setFirstMove(boolean firstMove);

    boolean isOnBoard();

    boolean isCapturable();

    PlayerColor getColor();
}
