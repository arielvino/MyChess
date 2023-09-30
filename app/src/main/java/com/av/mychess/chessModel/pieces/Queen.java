package com.av.mychess.chessModel.pieces;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.CommonStructs.PlayerColor;

import java.util.ArrayList;

public class Queen extends Rider {

    public Queen(PlayerColor color) {
        super(color);
    }

    @Override
    public ArrayList<Vector2D> directions() {
        final ArrayList<Vector2D> directions = new ArrayList<>();
        directions.add(new Vector2D(1, 1));
        directions.add(new Vector2D(1, 0));
        directions.add(new Vector2D(1, -1));
        directions.add(new Vector2D(0, 1));
        directions.add(new Vector2D(0, -1));
        directions.add(new Vector2D(-1, 1));
        directions.add(new Vector2D(-1, 0));
        directions.add(new Vector2D(-1, -1));
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

    @Override
    public void onTurnDone() {

    }
}
