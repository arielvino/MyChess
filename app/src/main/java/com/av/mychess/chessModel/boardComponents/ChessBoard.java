package com.av.mychess.chessModel.boardComponents;

import com.av.mychess.Interfaces.ModelInterfaces.IChessBoard;
import com.av.mychess.Interfaces.ModelInterfaces.IChessCell;
import com.av.mychess.Interfaces.ModelInterfaces.IChessGame;
import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.chessModel.Game;

public class ChessBoard implements IChessBoard {

    //the 2D array of cells:
    private final ModelCell[][] cells;
    private final Vector2D dimensions;

    //the x & y coordinates:
    private Game game;

    //Constructor:
    public ChessBoard(Game game, Vector2D dimensions) {
        this.dimensions = dimensions;
        this.game = game;
        this.cells = new ModelCell[dimensions.getX()][dimensions.getY()];
        for (int a = 0; a < dimensions.getX(); a++) {
            for (int b = 0; b < dimensions.getY(); b++) {
                cells[a][b] = new ModelCell(this, new Vector2D(a, b));
                game.addOnTurnDoneListener(cells[a][b]);
            }
        }

        //todo
    }

    @Override
    public IChessCell getCell(Vector2D location) {
        if (location.getX() >= 0 && location.getX() < this.dimensions.getX() && location.getY() >= 0 && location.getY() < this.dimensions.getY()) {
            return cells[location.getX()][location.getY()];
        } else {
            throw new ArrayIndexOutOfBoundsException("The cell You tried to get doesn't exist. Check the desired index.");
        }
    }

    @Override
    public IChessGame getGame() {
        return game;
    }

    //stack of

    /**
     * This method get a Location and indicates whether it is within the board's borders.
     *
     * @param location the specific location to check.
     * @return whether thw location is within the board's borders.
     */
    @Override
    public boolean isTheLocationOnBoard(Vector2D location) {
        return location.getX() >= 0 && location.getY() >= 0 && location.getX() < dimensions.getX() && location.getY() < dimensions.getY();
    }

    @Override
    public Vector2D getDimensions() {
        return dimensions;
    }

}
