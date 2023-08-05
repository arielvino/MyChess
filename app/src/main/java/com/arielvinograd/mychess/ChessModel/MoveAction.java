package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IBasicAction;
import com.arielvinograd.mychess.Interfaces.IChessCell;

/**
 * This type is an IBasicAction that represent a simple movement of a single piece from one cell to another on the board.
 */
public class MoveAction implements IBasicAction {
    private final IChessCell origin, destination;

    public MoveAction(IChessCell origin, IChessCell destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public IChessCell getOrigin() {
        return origin;
    }

    public IChessCell getDestination() {
        return destination;
    }
}
