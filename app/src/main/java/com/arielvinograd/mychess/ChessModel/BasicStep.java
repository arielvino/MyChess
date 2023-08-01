package com.arielvinograd.mychess.ChessModel;

/** This class represent a basic movement on the board.
* It is simply contain a reference for the specific piece that change its location, its origin location and its new location.
* Important: Thou shalt represent the location "out of the board" by the location (-1, -1).
*/
public class BasicStep {

    private final Location origin, target;
    private final com.arielvinograd.mychess.ChessModel.Piece Piece;

    public Location getOrigin() {
        return origin.clone();
    }

    public Location getTarget() {
        return target.clone();
    }

    public BasicStep(Location origin, Location target, Piece piece) {
        this.origin = origin.clone();
        this.target = target.clone();
        Piece = piece;
    }
}
