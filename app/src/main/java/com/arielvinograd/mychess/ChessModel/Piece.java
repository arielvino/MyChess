package com.arielvinograd.mychess.ChessModel;

public abstract class Piece {

    //keep the current cell that the piece is located on
    ModelCell currentCell;

    public ModelCell getCurrentCell() {
        return currentCell;
    }

    protected void setCurrentCell(ModelCell newCell) {
        this.currentCell = newCell;
    }

    /**
     * @return false if the current cell is null.
     */
    public boolean isOnBoard() {
        return currentCell != null;
    }

    //indicates whether the piece ever moved in the past:
    boolean firstMove = true;

    public boolean isFirstMove() {
        return firstMove;
    }

    protected void setFirstMove(boolean value) {
        firstMove = value;
    }

    //This methode indicate whether the piece is unmovable for some reason. for example: there is enemy Immobilizer nearby.
    boolean frozen;

    /**
     * This methode indicate whether the piece is unmovable for some reason. for example: there is enemy Immobilizer nearby.
     */
    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }
}
