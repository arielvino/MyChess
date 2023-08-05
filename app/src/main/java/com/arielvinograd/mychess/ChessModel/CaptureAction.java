package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IBasicAction;
import com.arielvinograd.mychess.Interfaces.IChessCell;
import com.arielvinograd.mychess.Interfaces.IChessPiece;

/**
 * This type is an IBasicAction that represent a piece that capture an opponent's piece and taking it's position.
 */
public class CaptureAction implements IBasicAction {
    private final IChessPiece capturedPiece;
    private final IChessCell capturingPieceOrigin, capturingPieceDestination;

    public CaptureAction(IChessPiece capturedPiece, IChessCell capturingPieceOrigin, IChessCell capturingPieceDestination) {
        this.capturedPiece = capturedPiece;
        this.capturingPieceOrigin = capturingPieceOrigin;
        this.capturingPieceDestination = capturingPieceDestination;
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
}
