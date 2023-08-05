package com.arielvinograd.mychess.Interfaces;

/**
 * This class is a struct that represent a 2D location.
 */
public class Location {
    private final int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Location add(Location vector) {
        return new Location(this.x + vector.x, this.y + vector.y);
    }
}
