package com.av.mychess.Interfaces.ModelInterfaces;

import com.av.mychess.CommonStructs.PlayerColor;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Stack;

public interface IChessGame {

    void abortGame();

    void handleTurnInfo(ITurnInfo turnInfo);

    @NotNull
    PlayerColor getCurrentTurn();

    @NotNull
    IChessBoard getBoard();

    @NotNull
    IChessPlayer getPlayer(@NotNull PlayerColor color);

    @NotNull
    IChessPlayer getOpponent(@NotNull PlayerColor currentPlayer);

    @Nullable
    ITurnInfo peekLastTurn();

    @NotNull
    Stack<ITurnInfo> lookAtGameHistory();

    //Events:
    void addGameEventsListener(@NotNull IGameEventsListener listener);

    //Interfaces:
    interface IGameEventsListener {
        /**
         * This method report the listener about actual turn that have been done right now.
         * The listener shall do things like updating the UI, send the info over network etc.
         * @param turnInfo the turn that have been done.
         */
        void receiveTurnInfo(@NotNull ITurnInfo turnInfo);

        void onCheckmate(@NotNull PlayerColor color);

        void onGameAborted();
    }

    /**
     This interface apply to objects like {@link IChessCell} and {@link IChessPiece} that need to update some attributes in response to a change in the board state, like prohibiting move if an Immobilizer is adjacent, etc.
     */
    interface IOnTurnDoneListener {
        void onTurnDone();
    }
}
