package com.av.mychess.chessModel.pieces;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.CommonStructs.PlayerColor;

import java.util.ArrayList;

/**
 * Just a Bishop.
 */
public class Bishop extends Rider {

    public Bishop(PlayerColor color) {
        super(color);
    }

    /**
     * Bishop can walk in diagonal directions.
     *
     * @return directions (vectors) that a Bishop can move along.
     */
    @Override
    public ArrayList<Vector2D> directions() {
        final ArrayList<Vector2D> directions = new ArrayList<>();
        directions.add(new Vector2D(1, 1));
        directions.add(new Vector2D(1, -1));
        directions.add(new Vector2D(-1, -1));
        directions.add(new Vector2D(-1, 1));
        return directions;
    }

    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public boolean isCapturable() {
        return true;
    }

    @Override
    public void onTurnDone() {

    }
}
