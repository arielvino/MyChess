package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IChessBoard;
import com.arielvinograd.mychess.Interfaces.IChessCell;
import com.arielvinograd.mychess.Interfaces.IChessGame;
import com.arielvinograd.mychess.Interfaces.Location;

public class ModelBoard implements IChessBoard {

    //the 2D array of cells:
    private final ModelCell[][] cells;
    private final int x, y;

    //the x & y coordinates:
    private Game game;

    //Constructor:
    public ModelBoard(Game game, int x, int y) {
        this.x = x;
        this.y = y;
        this.game = game;
        this.cells = new ModelCell[8][8];
        for (int a = 0; a < x; a++) {
            for (int b = 0; b < y; b++) {
                cells[a][b] = new ModelCell(this, new Location(a, b));
            }
        }

        //todo
    }

    public ModelCell getCell(int x, int y) {
        if (x >= 0 && x < this.x && y >= 0 && y < this.y) {
            return cells[x][y];
        } else {
            throw new ArrayIndexOutOfBoundsException("The cell You tried to get doesn't exist. Check the desired index.");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public IChessGame getGame() {
        return game;
    }

    //stack of

    /**
     * This methode get a Location and indicates whether it is within the board's borders.
     *
     * @param location the specific location to check.
     * @return whether thw location is within the board's borders.
     */
    @Override
    public boolean isTheLocationOnBoard(Location location) {
        return location.getX() >= 0 && location.getY() >= 0 && location.getX() < x && location.getY() < y;
    }

    @Override
    public IChessCell getCell(Location location) {
        return cells[location.getX()][location.getY()];
    }
}
