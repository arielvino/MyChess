package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IChessGame;
import com.arielvinograd.mychess.Interfaces.IChessPlayer;
import com.arielvinograd.mychess.Interfaces.ITurnInfo;
import com.arielvinograd.mychess.Interfaces.PlayerColor;

import java.util.Stack;

/**
 * This class represent a single chess game.
 * A game includes a BoardModel, 2 Players (black and white), and history logger made of chain of TurnInfo.
 */
public class Game implements IChessGame {
    public final Stack<TurnInfo> gameHistory = new Stack<>();
    private final ModelBoard board;
    private final Player black, white;
    private PlayerColor currentTurn;
    //Send turn event:
    private ITurnInfoReceiver receiver = null;

    //Constructor:
    public Game(String gameInitializingString) {
        //parse and initialize board size:
        int x = 8, y = 8;//todo
        board = new ModelBoard(this, x, y);

        //players:
        black = new Player(this, PlayerColor.Black);
        white = new Player(this, PlayerColor.White);
    }

    @Override
    public ModelBoard getBoard() {
        return board;
    }

    public Player getBlack() {
        return black;
    }

    @Override
    public IChessPlayer getOpponent(IChessPlayer currentPlayer) {
        //todo
        return null;
    }

    public Player getWhite() {
        return white;
    }

    /**
     * This method returns a clone of the game history, so it is useful only for reading the history, and not for editing it.
     */
    @Override
    public Stack<ITurnInfo> lookAtGameHistory() {
        return (Stack<ITurnInfo>) gameHistory.clone();
    }

    /**
     * This methode push a new turn into the history logger's stack.
     *
     * @param newTurn the new turn info.
     */
    private void pushToHistory(TurnInfo newTurn) {
        gameHistory.push(newTurn);
    }

    /**
     * This methode let you read the last turn that had done in the game (used mainly for en passant, but also for graphic highlights etc.)
     */
    public TurnInfo peekLastTurn() {
        Stack<TurnInfo> copy = (Stack<TurnInfo>) gameHistory.clone();
        return copy.peek();
    }

    @Override
    public void addOnCheckmateListener(IOnCheckmateListener listener) {
//todo
    }

    @Override
    public void addOnGameAbortedListener(IOnGameAbortedListener listener) {
        //todo
    }

    @Override
    public void abortGame() {
        //todo
    }

    @Override
    public void handleTurnInfo(ITurnInfo turnInfo) {
        //todo
    }

    public PlayerColor getCurrentTurn() {
        return currentTurn;
    }

    /**
     * This methode simply give the turn to the other player.
     */
    private void changeTurn() {
        if (currentTurn == PlayerColor.White) {
            currentTurn = PlayerColor.Black;
        } else {
            currentTurn = PlayerColor.White;
        }
    }

    @Override
    public void setTurnInfoReceiver(ITurnInfoReceiver receiver) {
        this.receiver = receiver;
    }

    /**
     * This methode invokes an event that notify the turnInfoReceiver.
     *
     * @param turnInfo the TurnInfo that you want to send.
     */
    private void sendTurnInfo(TurnInfo turnInfo) {
        receiver.onTurnInfoReceived(turnInfo);
    }
}
