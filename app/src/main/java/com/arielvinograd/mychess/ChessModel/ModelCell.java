package com.arielvinograd.mychess.ChessModel;

import java.util.ArrayList;

/**
 * This type represent a cell on a ModelBoard.
 */
public class ModelCell {

    //coordinates:
    public final int x, y;

    //current piece attribute:
    private Piece piece;

    public Piece getPiece() {
        return piece;
    }

    protected void setPiece(Piece newPiece) {
        piece = newPiece;
        invokePieceChangedEvent();
    }

    //which board is belong to:
    public final ModelBoard board;

    //todo target

    //Constructor:
    public ModelCell(ModelBoard board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
    }

    //Events:

    //piece changed event:
    private final ArrayList<OnPieceChangedListener> onPieceChangedListeners = new ArrayList<>();

    public void setOnPieceChangedListeners(OnPieceChangedListener listener) {
        onPieceChangedListeners.add(listener);
    }

    public void invokePieceChangedEvent() {
        for (OnPieceChangedListener listener : onPieceChangedListeners) {
            listener.onPieceChanged();
        }
    }

    public interface OnPieceChangedListener {
        void onPieceChanged();
    }
}
