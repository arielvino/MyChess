package com.arielvinograd.mychess;

import java.util.Stack;

/**
 * This class represent a single chess game.
 * A game includes a BoardModel, 2 Players (black and white), and history logger made of chain of TurnInfo.
 */
public class Game {
    private final ModelBoard board;

    public ModelBoard getBoard() {
        return board;
    }

    private final Player black, white;

    public Player getBlack() {
        return black;
    }

    public Player getWhite() {
        return white;
    }

    public final Stack<TurnInfo>  gameHistory = new Stack<>();

    /**
     * This method returns a clone of the game history, so it is useful only for reading the history, and not for editing it.
     */
    public Stack<TurnInfo> getGameHistory() {
        return (Stack<TurnInfo>) gameHistory.clone();
    }

    /**
     * This methode push a new turn into the history logger's stack.
     * @param newTurn the new turn info.
     */
    public void pushToHistory(TurnInfo newTurn){
        //todo some test
        gameHistory.push(newTurn);
    }

    /**
     * This methode let you read the last turn that had done in the game (used mainly for en passant, but also for graphic highlights etc. ).
     */
    public TurnInfo peekLastTurn(){
        Stack<TurnInfo> copy = (Stack<TurnInfo>) gameHistory.clone();
        return copy.peek();
    }

    //Constructor:
    public Game(String gameInitializingString){
        //parse and initialize board size:
        int x = 8, y = 8;//todo
        board = new ModelBoard(x, y);

        //players:
        black = new Player(this);
        white = new Player(this);
    }
}
