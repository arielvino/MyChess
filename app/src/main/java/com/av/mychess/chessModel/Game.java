package com.av.mychess.chessModel;

import androidx.annotation.NonNull;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IChessBoard;
import com.av.mychess.Interfaces.ModelInterfaces.IChessGame;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPlayer;
import com.av.mychess.Interfaces.ModelInterfaces.ITurnInfo;
import com.av.mychess.XmlFactory;
import com.av.mychess.chessModel.boardComponents.ChessBoard;
import com.av.mychess.chessModel.turnComponents.TurnInfo;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * This class represent a single chess game.
 * A game includes a BoardModel, 2 Players (black and white), and history logger made of chain of TurnInfo.
 */
public class Game implements IChessGame {
    public final Stack<ITurnInfo> gameHistory = new Stack<>();
    private final IChessBoard board;
    private final IChessPlayer black, white;
    private final ArrayList<IOnTurnDoneListener> onTurnDoneListeners = new ArrayList<>();
    private PlayerColor currentTurn;
    private IChessGame testingTurnsGame;//todo
    //Send turn event:
    private IGameEventsListener receiver = null;

    //Constructor:
    public Game(Document document) {
        //parse and initialize board size:
        String width = document.getElementsByTagName(XmlFactory.BOARD).item(0).getAttributes().getNamedItem(XmlFactory.X).getNodeValue();
        String height = document.getElementsByTagName(XmlFactory.BOARD).item(0).getAttributes().getNamedItem(XmlFactory.Y).getNodeValue();
        int x = Integer.getInteger(width), y = Integer.getInteger(height);//todo
        board = new ChessBoard(this, new Vector2D(x, y));

        //players:
        black = new Player(this, PlayerColor.Black);
        white = new Player(this, PlayerColor.White);

        //add pieces:
        for (int i = 0; i < document.getElementsByTagName(XmlFactory.PIECE).getLength(); i++) {
            Node pieceNode = document.getElementsByTagName(XmlFactory.PIECE).item(i);

            try {
                //get class name:
                String className = "com.av.mychess.chessModel.pieces." + pieceNode.getAttributes().getNamedItem(XmlFactory.NAME).getNodeValue();

                //get type:
                Class<?> clazz = Class.forName(className);

                //get constructor:
                Constructor<?> constructor = clazz.getConstructor(PlayerColor.class);

                //get attributes:
                String color = pieceNode.getAttributes().getNamedItem(XmlFactory.COLOR).getNodeValue();
                PlayerColor playerColor = color == XmlFactory.WHITE ? PlayerColor.White : PlayerColor.Black;

                //create instance:
                IChessPiece instance = (IChessPiece) constructor.newInstance(playerColor);

                //add to the player:
                getPlayer(playerColor).getPieces().add(instance);

                //place on the board:
                String xPosition = pieceNode.getAttributes().getNamedItem(XmlFactory.X).getNodeValue();
                String yPosition = pieceNode.getAttributes().getNamedItem(XmlFactory.Y).getNodeValue();
                instance.setCell(board.getCell(new Vector2D(Integer.getInteger(xPosition), Integer.getInteger(yPosition))));


            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                     IllegalAccessException | InvocationTargetException |
                     IllegalArgumentException e) {
                e.printStackTrace();
                //todo: handle the exception.
            }

        }

    }

    @Override
    public IChessBoard getBoard() {
        return board;
    }

    @NonNull
    @Override
    public IChessPlayer getPlayer(@NonNull PlayerColor color) {
        //todo
        return null;
    }

    @Override
    public IChessPlayer getOpponent(PlayerColor currentPlayer) {
        if (currentPlayer == PlayerColor.White) {
            return black;
        }
        if (currentPlayer == PlayerColor.Black) {
            return white;
        }
        return null;
    }

    /**
     * This method returns a clone of the game history, so it is useful only for reading the history, and not for editing it.
     */
    @Override
    public Stack<ITurnInfo> lookAtGameHistory() {
        return (Stack<ITurnInfo>) gameHistory.clone();
    }

    @Override
    public void addGameEventsListener(@NonNull IGameEventsListener listener) {

    }

    /**
     * This method push a new turn into the history logger's stack.
     *
     * @param newTurn the new turn info.
     */
    private void pushToHistory(TurnInfo newTurn) {
        gameHistory.push(newTurn);
    }

    /**
     * This method let you read the last turn that had done in the game (used mainly for en passant, but also for graphic highlights etc.)
     */
    @Override
    public ITurnInfo peekLastTurn() {
        Stack<ITurnInfo> copy = (Stack<ITurnInfo>) gameHistory.clone();
        return copy.peek();
    }

    @Override
    public void abortGame() {
        //todo
    }

    @Override
    public void handleTurnInfo(ITurnInfo turnInfo) {
        //todo
    }

    @Override
    public PlayerColor getCurrentTurn() {
        return currentTurn;
    }

    /**
     * This method simply give the turn to the other player.
     */
    private void changeTurn() {
        if (currentTurn == PlayerColor.White) {
            currentTurn = PlayerColor.Black;
        } else {
            currentTurn = PlayerColor.White;
        }
    }

    /**
     * This method invokes an event that notify the turnInfoReceiver.
     *
     * @param turnInfo the TurnInfo that you want to send.
     */
    private void sendTurnInfo(ITurnInfo turnInfo) {
        receiver.receiveTurnInfo(turnInfo);
        //todo
    }

    private boolean makeTurn(ITurnInfo turnInfo) {
        //todo
        changeTurn();
        invokeOnTurnDoneEvent();
        return false;
    }

    public void addOnTurnDoneListener(IOnTurnDoneListener listener) {
        onTurnDoneListeners.add(listener);
    }

    private void invokeOnTurnDoneEvent() {
        for (IOnTurnDoneListener listener : onTurnDoneListeners) {
            listener.onTurnDone();
        }
    }
}
