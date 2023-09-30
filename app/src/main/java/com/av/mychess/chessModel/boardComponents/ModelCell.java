package com.av.mychess.chessModel.boardComponents;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.ICellRule;
import com.av.mychess.Interfaces.ModelInterfaces.IChessBoard;
import com.av.mychess.Interfaces.ModelInterfaces.IChessCell;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.chessModel.pieces.Piece;

import java.util.ArrayList;

/**
 * This type represent a cell on a ModelBoard.
 */
public class ModelCell implements IChessCell {

    //coordinates:
    private final Vector2D location;

    //which board is belong to:
    private final ChessBoard board;

    //piece changed event:
    private final ArrayList<IOnPieceChangedListener> onPieceChangedListeners = new ArrayList<>();

    //current piece attribute:
    private Piece piece;

    //list of rules:
    private final ArrayList<ICellRule> rules = new ArrayList<>();

    //Constructor:
    public ModelCell(ChessBoard board, Vector2D location) {
        this.board = board;
        this.location = location;
    }

    @Override
    public Vector2D getLocation() {
        return location;
    }

    @Override
    public Piece getPiece() {
        return piece;
    }

    @Override
    public void setPiece(IChessPiece newPiece) {
        this.piece = (Piece) newPiece;
        invokePieceChangedEvent();
    }

    @Override
    public IChessBoard getBoard() {
        return board;
    }

    @Override
    public boolean isRuleExist(ICellRule rule) {
        for (ICellRule r : rules) {
            if (rule.identical(r)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addRule(ICellRule rule) {
        if (!isRuleExist(rule)) {
            rules.add(rule);
        }
    }

    @Override
    public void removeRule(ICellRule rule) {
        for (ICellRule r : rules) {
            if(rule.identical(r)){
                rules.remove(r);
                return;
            }
        }
    }

    //Listeners:

    @Override
    public void onTurnDone() {
        //todo
    }

    //Events:

    @Override
    public void addOnPieceChangedListener(IOnPieceChangedListener listener) {
        onPieceChangedListeners.add(listener);
    }

    public void invokePieceChangedEvent() {
        for (IOnPieceChangedListener listener : onPieceChangedListeners) {
            listener.onPieceChanged();
        }
    }
}