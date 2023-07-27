package com.arielvinograd.mychess;

/**
 * This class is a struct that represent a 2D location.
 */
public class Location {
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * This methode returns a copy of the object, representing the same location.
     * @return a copy of the location.
     */
    public Location clone(){
        return new Location(x, y);
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
