package com.arielvinograd.mychess.Interfaces;

public interface IChessBoard {
    IChessCell getCell(Location location);

    int getX();

    int getY();

    IChessGame getGame();

    boolean isTheLocationOnBoard(Location location);
}
