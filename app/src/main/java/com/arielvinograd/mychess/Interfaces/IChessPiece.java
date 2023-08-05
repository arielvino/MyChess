package com.arielvinograd.mychess.Interfaces;

import java.util.ArrayList;

public interface IChessPiece {
    ArrayList<ITarget> getUncheckedPossibleTargets();

    ArrayList<Location> getThreatenedLocations();

    String getName();

    IChessCell getCell();

    void setCell(IChessCell newCell);

    boolean isFrozen();

    void setFrozen(boolean frozen);

    boolean isFirstMove();

    boolean isOnBoard();

    boolean isCapturable();

    PlayerColor getColor();
}
