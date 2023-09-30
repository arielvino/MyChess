package com.av.mychess.Interfaces.ModelInterfaces;

import com.av.mychess.CommonStructs.Vector2D;

public interface IChessCell extends IChessGame.IOnTurnDoneListener {
    Vector2D getLocation();

    IChessPiece getPiece();

    void setPiece(IChessPiece piece);

    IChessBoard getBoard();

    boolean isRuleExist(ICellRule rule);

    void addRule(ICellRule rule);

    void removeRule(ICellRule rule);

    //Events:
    void addOnPieceChangedListener(IOnPieceChangedListener listener);

    //Interfaces
    interface IOnPieceChangedListener {
        void onPieceChanged();
    }
}
