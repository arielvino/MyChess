package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IBasicAction;
import com.arielvinograd.mychess.Interfaces.IChessCell;
import com.arielvinograd.mychess.Interfaces.IChessPiece;

/**
 * This type representing an IBasicAction of a Castling turn.
 */
public class CastlingAction implements IBasicAction {
    private final IChessCell kingOrigin, kingDestination, rookOrigin, rookDestination;
    private final IChessPiece king, rook;

    public CastlingAction(IChessPiece king, IChessPiece rook, IChessCell kingOrigin, IChessCell kingDestination, IChessCell rookOrigin, IChessCell rookDestination) {
        this.king = king;
        this.rook = rook;
        this.kingOrigin = kingOrigin;
        this.kingDestination = kingDestination;
        this.rookOrigin = rookOrigin;
        this.rookDestination = rookDestination;
    }

    public IChessCell getKingOrigin() {
        return kingOrigin;
    }

    public IChessCell getKingDestination() {
        return kingDestination;
    }

    public IChessCell getRookOrigin() {
        return rookOrigin;
    }

    public IChessCell getRookDestination() {
        return rookDestination;
    }

    public IChessPiece getKing() {
        return king;
    }

    public IChessPiece getRook() {
        return rook;
    }
}
