package com.arielvinograd.mychess.Interfaces;

public interface IChessCell {
    Location getLocation();

    IChessPiece getPiece();

    void setPiece(IChessPiece piece);

    IChessBoard getBoard();

    //Events:
    void addOnPieceChangedListener(IOnPieceChangedListener listener);

    //Interfaces
    interface IOnPieceChangedListener {
        void onPieceChanged();
    }
}
