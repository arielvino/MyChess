package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IChessCell;
import com.arielvinograd.mychess.Interfaces.IChessPiece;
import com.arielvinograd.mychess.Interfaces.PlayerColor;

public abstract class Piece implements IChessPiece {

    private final PlayerColor color;
    //keep the current cell that the piece is located on
    IChessCell currentCell;
    //indicates whether the piece ever moved in the past:
    boolean firstMove = true;
    //This methode indicate whether the piece is unmovable for some reason. for example: there is enemy Immobilizer nearby.
    boolean frozen;

    public Piece(PlayerColor color) {
        this.color = color;
    }

    public PlayerColor getColor() {
        return color;
    }

    public IChessCell getCell() {
        return currentCell;
    }

    public void setCell(IChessCell newCell) {
        this.currentCell = newCell;
    }

    /**
     * @return false if the current cell is null.
     */
    public boolean isOnBoard() {
        return currentCell != null;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    protected void setFirstMove(boolean value) {
        firstMove = value;
    }

    /**
     * This methode indicate whether the piece is unmovable for some reason. for example: there is enemy Immobilizer nearby.
     */
    public boolean isFrozen() {
        return frozen;
    }

    /**
     * This methode is used in order to set the Frozen value of a piece.
     *
     * @param frozen the new frozen value.
     */
    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }
}
