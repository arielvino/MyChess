package com.arielvinograd.mychess.ChessModel.Pieces;

import com.arielvinograd.mychess.ChessModel.Rider;
import com.arielvinograd.mychess.Interfaces.Location;
import com.arielvinograd.mychess.Interfaces.PlayerColor;

import java.util.ArrayList;

public class Queen extends Rider {

    public Queen(PlayerColor color) {
        super(color);
    }

    @Override
    public ArrayList<Location> directions() {
        final ArrayList<Location> directions = new ArrayList<>();
        directions.add(new Location(1, 1));
        directions.add(new Location(1, 0));
        directions.add(new Location(1, -1));
        directions.add(new Location(0, 1));
        directions.add(new Location(0, -1));
        directions.add(new Location(-1, 1));
        directions.add(new Location(-1, 0));
        directions.add(new Location(-1, -1));
        return directions;
    }

    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public boolean isCapturable() {
        return true;
    }
}
