package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.Location;

/**
 * This class represent a basic movement on the board.
 * It is simply contain a reference for the specific piece that change its location, its origin location and its new location.
 * Important: Thou shalt represent the location "out of the board" by the location (-1, -1).
 */
public class Move implements IBasicTurn {

    private final Location origin, target;
    private final com.arielvinograd.mychess.ChessModel.Piece Piece;

    public Move(Location origin, Location target, Piece piece) {
        this.origin = origin;
        this.target = target;
        Piece = piece;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getTarget() {
        return target;
    }
}
