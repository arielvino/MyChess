package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IChessBoard;
import com.arielvinograd.mychess.Interfaces.IChessCell;
import com.arielvinograd.mychess.Interfaces.IChessPiece;
import com.arielvinograd.mychess.Interfaces.Location;

import java.util.ArrayList;

/**
 * This type represent a cell on a ModelBoard.
 */
public class ModelCell implements IChessCell {

    //coordinates:
    private final Location location;
    //which board is belong to:
    private final ModelBoard board;
    //piece changed event:
    private final ArrayList<IOnPieceChangedListener> onPieceChangedListeners = new ArrayList<>();
    //current piece attribute:
    private Piece piece;

    //Constructor:
    public ModelCell(ModelBoard board, Location location) {
        this.board = board;
        this.location = location;
    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public Piece getPiece() {
        return piece;
    }

    @Override
    public void setPiece(IChessPiece newPiece) {
        this.piece = (Piece) piece;
        invokePieceChangedEvent();
    }

    @Override
    public IChessBoard getBoard() {
        return board;
    }

    //Events:

    @Override
    public void addOnPieceChangedListener(IOnPieceChangedListener listener) {
        //todo
    }

    public void setOnPieceChangedListeners(IOnPieceChangedListener listener) {
        onPieceChangedListeners.add(listener);
    }

    public void invokePieceChangedEvent() {
        for (IOnPieceChangedListener listener : onPieceChangedListeners) {
            listener.onPieceChanged();
        }
    }
}
