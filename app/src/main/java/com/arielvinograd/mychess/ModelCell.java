package com.arielvinograd.mychess;

public class ModelCell {

    //coordinates:
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //current piece attribute:
    private Piece piece;
    public Piece getPiece(){
        return piece;
    }
    protected void setPiece(Piece newPiece){
        piece = newPiece;
    }

    //which board is belong to:
    private ModelBoard board;
    public ModelBoard getBoard(){
        return board;
    }

    public ModelCell(ModelBoard board, int x, int y){
        this.board = board;
        this.x = x;
        this.y = y;
    }
}
