package com.av.mychess.Interfaces.ModelInterfaces;

import com.av.mychess.CommonStructs.Vector2D;

public interface IChessBoard {
    IChessCell getCell(Vector2D location);

    Vector2D getDimensions();

    IChessGame getGame();

    boolean isTheLocationOnBoard(Vector2D location);

    int DEFAULT_SIZE = 8;
}
