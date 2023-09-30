package com.av.mychess.chessModel.pieces;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.Interfaces.ModelInterfaces.IChessCell;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;

public abstract class Piece implements IChessPiece {

    private final PlayerColor color;
    //keep the current cell that the piece is located on
    IChessCell currentCell;
    //indicates whether the piece ever moved in the past:
    private boolean firstMove = true;

    public Piece(PlayerColor color) {
        this.color = color;
    }

    @Override
    public PlayerColor getColor() {
        return color;
    }

    @Override
    public IChessCell getCell() {
        return currentCell;
    }

    @Override
    public void setCell(IChessCell newCell) {
        this.currentCell = newCell;
        //todo check surroundings for effecting pieces
    }

    @Override
    public boolean isFirstMove() {
        return firstMove;
    }

    @Override
    public void setFirstMove(boolean value) {
        firstMove = value;
    }

    @Override
    public boolean isOnBoard() {
        return currentCell != null;
    }
}
