package com.av.mychess.chessModel.turnComponents;

import com.av.mychess.Interfaces.ModelInterfaces.IBasicAction;
import com.av.mychess.Interfaces.ModelInterfaces.IChessCell;

/**
 * This type is an IBasicAction that represent a simple movement of a single piece from one cell to another on the board.
 */
public class MoveAction implements IBasicAction {
    private final IChessCell origin, destination;
    private final boolean isItTheFirstMove;

    public MoveAction(IChessCell origin, IChessCell destination, boolean isItTheFirstMove) {
        this.origin = origin;
        this.destination = destination;
        this.isItTheFirstMove = isItTheFirstMove;
    }

    public IChessCell getOrigin() {
        return origin;
    }

    public IChessCell getDestination() {
        return destination;
    }

    public boolean isItTheFirstMove() {
        return isItTheFirstMove;
    }
}
