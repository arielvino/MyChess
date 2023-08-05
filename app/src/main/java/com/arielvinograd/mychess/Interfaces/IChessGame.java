package com.arielvinograd.mychess.Interfaces;

import java.util.Stack;

public interface IChessGame {

    void abortGame();

    void handleTurnInfo(ITurnInfo turnInfo);

    PlayerColor getCurrentTurn();

    IChessBoard getBoard();

    IChessPlayer getWhite();

    IChessPlayer getBlack();

    IChessPlayer getOpponent(IChessPlayer currentPlayer);

    ITurnInfo peekLastTurn();

    Stack<ITurnInfo> lookAtGameHistory();

    //Events:
    void addOnCheckmateListener(IOnCheckmateListener listener);

    void addOnGameAbortedListener(IOnGameAbortedListener listener);

    void setTurnInfoReceiver(ITurnInfoReceiver receiver);

    //Interfaces:
    interface ITurnInfoReceiver {
        void onTurnInfoReceived(ITurnInfo turnInfo);
    }

    interface IOnCheckmateListener {
        void onCheckmate(PlayerColor color);
    }

    interface IOnGameAbortedListener {
        void onGameAborted();
    }
}
