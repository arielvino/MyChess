package com.arielvinograd.mychess;

public class ModelBoard {

    //the 2D array of cells:
    private final ModelCell[][] cells;

    public ModelCell getCell(int x, int y) {
        if (x >= 0 && x < this.x && y >= 0 && y < this.y) {
            return cells[x][y];
        } else {
            throw new ArrayIndexOutOfBoundsException("The cell You tried to get doesn't exist. Check the desired index.");
        }
    }

    //the x & y coordinates:

    private final int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //stack of

    //Constructor:
    public ModelBoard(int x, int y) {
        this.x = x;
        this.y = y;
        this.cells=new ModelCell[8][8];
        for(int a =0;a<x;a++)
        {
            for (int b = 0; b < y; b++) {
                cells[a][b]=new ModelCell(this, a, b);
            }
        }

        //todo
    }

}
