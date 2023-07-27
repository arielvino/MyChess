package com.arielvinograd.mychess;

import java.util.ArrayList;

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

    //this methode is called when the user click on the cell:
    public void notifyThatTheCellClicked() {
        board.onCellClicked(this);
    }

    //this methode let the cell know when it's selected or unselected, and invoke the appropriate event on the UI:

    //Events:

    //target changed event:
    private final ArrayList<OnTargetChangedListener> onTargetChangedListeners = new ArrayList<>();

    public void setOnTargetChangedListeners(OnTargetChangedListener listener) {
        onTargetChangedListeners.add(listener);
    }

    public void invokeTargetChangedEvent() {
        for (OnTargetChangedListener listener : onTargetChangedListeners) {
            listener.onTargetChanged();
        }
    }

    public interface OnTargetChangedListener {
        void onTargetChanged();
    }
    
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
    
    //selection changed event:
    private final ArrayList<OnSelectionChangedListener> onSelectionChangedListeners = new ArrayList<>();

    public void setOnSelectionChangedListeners(OnSelectionChangedListener listener) {
        onSelectionChangedListeners.add(listener);
    }

    public void invokeSelectionChangedEvent(boolean selected) {
        for (OnSelectionChangedListener listener : onSelectionChangedListeners) {
            listener.onSelectionChanged(selected);
        }
    }

    public interface OnSelectionChangedListener {
        void onSelectionChanged( boolean selected);
    }
}
