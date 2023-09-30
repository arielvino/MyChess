package com.av.mychess.CommonStructs;

/**
 * This class is a struct that represent a 2D vector. Useful for: locations, directions and more.
 */
public class Vector2D {
    private final int x, y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * This method sum this vector with another and return the result as a new object.
     * Useful for calculating direction and relatives locations.
     *
     * @param vector the vector you want to add.
     * @return new vector with the values of the two vectors added together.
     */
    public Vector2D add(Vector2D vector) {
        return new Vector2D(this.x + vector.x, this.y + vector.y);
    }

    public boolean containedInRectangular(Vector2D vector) {
        return vector.x >= 0 && vector.x < x && vector.y >= 0 && vector.y < y;
    }
}
