package com.av.mychess.chessModel.turnComponents;

import com.av.mychess.Interfaces.ModelInterfaces.IBasicAction;
import com.av.mychess.Interfaces.ModelInterfaces.IChessCell;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;

/**
 * This type is an IBasicAction that represent a piece that capture an opponent's piece and taking it's position.
 */
public class CaptureAction implements IBasicAction {
    private final IChessPiece capturedPiece;
    private final IChessCell capturingPieceOrigin, capturingPieceDestination;
    private final boolean isItTheFirstMove;

    public CaptureAction(IChessPiece capturedPiece, IChessCell capturingPieceOrigin, IChessCell capturingPieceDestination, boolean isItTheFirstMove) {
        this.capturedPiece = capturedPiece;
        this.capturingPieceOrigin = capturingPieceOrigin;
        this.capturingPieceDestination = capturingPieceDestination;
        this.isItTheFirstMove = isItTheFirstMove;
    }

    public IChessPiece getCapturedPiece() {
        return capturedPiece;
    }

    public IChessCell getCapturingPieceOrigin() {
        return capturingPieceOrigin;
    }

    public IChessCell getCapturingPieceDestination() {
        return capturingPieceDestination;
    }

    public boolean isItTheFirstMove() {
        return isItTheFirstMove;
    }
}
