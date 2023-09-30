package com.av.mychess.chessModel.pieces;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.CommonStructs.PlayerColor;

import java.util.ArrayList;

public class NightRider extends Rider {

    public NightRider(PlayerColor color) {
        super(color);
    }

    @Override
    public ArrayList<Vector2D> directions() {
        final ArrayList<Vector2D> directions = new ArrayList<>();
        directions.add(new Vector2D(1, 2));
        directions.add(new Vector2D(1, -2));
        directions.add(new Vector2D(-1, -2));
        directions.add(new Vector2D(-1, 2));
        directions.add(new Vector2D(2, 1));
        directions.add(new Vector2D(2, -1));
        directions.add(new Vector2D(-2, -1));
        directions.add(new Vector2D(-2, 1));
        return directions;
    }

    @Override
    public String getName() {
        return "NightRider";
    }

    @Override
    public boolean isCapturable() {
        return true;
    }

    @Override
    public void onTurnDone() {

    }
}
