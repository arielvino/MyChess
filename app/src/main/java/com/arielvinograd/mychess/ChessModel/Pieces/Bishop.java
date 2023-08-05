package com.arielvinograd.mychess.ChessModel.Pieces;

import com.arielvinograd.mychess.ChessModel.Rider;
import com.arielvinograd.mychess.Interfaces.Location;
import com.arielvinograd.mychess.Interfaces.PlayerColor;

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
    public ArrayList<Location> directions() {
        final ArrayList<Location> directions = new ArrayList<>();
        directions.add(new Location(1, 1));
        directions.add(new Location(1, -1));
        directions.add(new Location(-1, -1));
        directions.add(new Location(-1, 1));
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
}
