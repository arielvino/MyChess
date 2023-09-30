package com.av.mychess.chessModel.pieces;

import com.av.mychess.chessModel.turnComponents.CaptureAction;
import com.av.mychess.chessModel.boardComponents.CapturingNotAllowedRule;
import com.av.mychess.chessModel.boardComponents.LandingNotAllowedRule;
import com.av.mychess.chessModel.turnComponents.MoveAction;
import com.av.mychess.chessModel.turnComponents.TurnInfo;
import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IBasicAction;
import com.av.mychess.Interfaces.ModelInterfaces.ICapturingPiece;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.Interfaces.ModelInterfaces.IMovablePiece;
import com.av.mychess.Interfaces.ModelInterfaces.ITurnInfo;

import java.util.ArrayList;

public abstract class Leaper extends Piece implements IMovablePiece, ICapturingPiece {
    public Leaper(PlayerColor color) {
        super(color);
    }

    public abstract ArrayList<Vector2D> getDestinations();

    @Override
    public ArrayList<ITurnInfo> getUncheckedPossibleTurns() {
        //not on board -> null
        if (!isOnBoard()) {
            return null;
        }

        final ArrayList<ITurnInfo> destinations = new ArrayList<>();

        //not allowed to move -> return empty
        if (!allowedToMove()) {
            return destinations;
        }

        //for each destination:
        for (Vector2D destination : getDestinations()) {
            Vector2D checkedLocation = getCell().getLocation().add(destination);
            if (getCell().getBoard().isTheLocationOnBoard(checkedLocation)) {
                IChessPiece piece = getCell().getBoard().getCell(checkedLocation).getPiece();
                //has piece -> capture target:
                if (piece != null) {
                    //enemy:
                    if (piece.getColor() != getColor()) {
                        //capturable:
                        if (piece.isCapturable()) {
                            //allowed to capture:
                            if (allowedToCapture()) {
                                //allowed to capture here:
                                if (!piece.getCell().isRuleExist(new CapturingNotAllowedRule(getColor()))) {
                                    CaptureAction captureAction = new CaptureAction(piece, getCell(), piece.getCell(), isFirstMove());
                                    ArrayList<IBasicAction> actions = new ArrayList<>();
                                    actions.add(captureAction);

                                    ITurnInfo capture = new TurnInfo(actions);
                                    destinations.add(capture);
                                }
                            }
                        }
                    }
                }
                //empty -> move target:
                else {
                    //allowed to land there:
                    if (!piece.getCell().isRuleExist(new LandingNotAllowedRule(getColor()))) {
                        MoveAction moveAction = new MoveAction(getCell(), getCell().getBoard().getCell(checkedLocation), isFirstMove());
                        ArrayList<IBasicAction> actions = new ArrayList<>();
                        actions.add(moveAction);

                        ITurnInfo move = new TurnInfo(actions);
                        destinations.add(move);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Vector2D> getThreatenedLocations() {
        //todo
        return null;
    }
}
