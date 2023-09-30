package com.av.mychess.chessModel.turnComponents;

import com.av.mychess.Interfaces.ModelInterfaces.IBasicAction;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;

public class ChangeIsFirstMoveAction implements IBasicAction {
    private final IChessPiece movedPiece;

    public IChessPiece getMovedPiece() {
        return movedPiece;
    }

    public ChangeIsFirstMoveAction(IChessPiece movedPiece){
        this.movedPiece = movedPiece;
    }
}
