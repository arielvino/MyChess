package com.av.mychess.chessModel.pieces;

import com.av.mychess.chessModel.turnComponents.CaptureAction;
import com.av.mychess.chessModel.boardComponents.CapturingNotAllowedRule;
import com.av.mychess.chessModel.boardComponents.ImpassableRule;
import com.av.mychess.chessModel.turnComponents.MoveAction;
import com.av.mychess.chessModel.turnComponents.TurnInfo;
import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IBasicAction;
import com.av.mychess.Interfaces.ModelInterfaces.ICapturingPiece;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.Interfaces.ModelInterfaces.IMovablePiece;
import com.av.mychess.Interfaces.ModelInterfaces.IPassingPiece;
import com.av.mychess.Interfaces.ModelInterfaces.ITurnInfo;

import java.util.ArrayList;

public abstract class Rider extends Piece implements IMovablePiece, ICapturingPiece, IPassingPiece {

    public Rider(PlayerColor color) {
        super(color);
    }

    /**
     * This method return a list of directions.
     * Direction is described by 1, 0, -1.
     * For example, the direction up is described as (0, 1), And the direction down-left is (-1, -1).
     *
     * @return list of Locations that are actually vectors that represent the general directions that the piece move along.
     */
    public abstract ArrayList<Vector2D> directions();

    @Override
    public ArrayList<ITurnInfo> getUncheckedPossibleTurns() {
        //not on board -> null:
        if (!isOnBoard()) {
            return null;
        }

        final ArrayList<ITurnInfo> possibleTurns = new ArrayList<>();

        //not allowed to move -> return an empty list:
        if (!allowedToMove()) {
            return possibleTurns;
        }

        //each direction checked:
        for (Vector2D direction : directions()) {
            Vector2D checkedLocation = getCell().getLocation();//get the location of the piece.
            //each iteration took one step in the checked direction:
            for (; getCell().getBoard().isTheLocationOnBoard(checkedLocation); checkedLocation = checkedLocation.add(direction)) {
                IChessPiece piece = getCell().getBoard().getCell(checkedLocation).getPiece();
                //empty cell -> move to:
                if (piece == null) {
                    //the player is allowed to pass through the empty cell:
                    if (!getCell().getBoard().getCell(checkedLocation).isRuleExist(new ImpassableRule(getColor()))) {
                        //add move action:
                        MoveAction movement = new MoveAction(getCell(), getCell().getBoard().getCell(checkedLocation), isFirstMove());
                        ArrayList<IBasicAction> actions = new ArrayList<>();
                        actions.add(movement);

                        //add possible turn
                        TurnInfo move = new TurnInfo(actions);
                        possibleTurns.add(move);
                    } else {
                        break;//you cannot pass anymore in this direction
                    }
                }
                //occupied cell -> capture it:
                else {
                    //opponent:
                    if (piece.getColor() != getColor()) {
                        //capturable:
                        if (piece.isCapturable()) {
                            //the player is allowed to capture in the cell
                            if (!getCell().getBoard().getCell(checkedLocation).isRuleExist(new ImpassableRule(getColor()))) {
                                //the piece is allowed to capture
                                if (allowedToCapture()) {
                                    //add capture action:
                                    CaptureAction captureAction = new CaptureAction(piece, getCell(), piece.getCell(), isFirstMove());
                                    ArrayList<IBasicAction> actions = new ArrayList<>();
                                    actions.add(captureAction);

                                    //add possible turn:
                                    TurnInfo capture = new TurnInfo(actions);
                                    possibleTurns.add(capture);
                                }
                            }
                        }
                    }
                    break;//a rider can not advance in this direction anymore if it has encountered an occupied cell
                }
            }
        }
        return possibleTurns;
    }

    @Override
    public ArrayList<Vector2D> getThreatenedLocations() {
        //not on board -> null
        if (!isOnBoard()) {
            return null;
        }

        final ArrayList<Vector2D> threatened = new ArrayList<>();

        //not allowed to capture -> return an empty list:
        if (!allowedToCapture()) {
            return threatened;
        }

        //each direction checked:
        for (Vector2D direction : directions()) {
            Vector2D checkedLocation = getCell().getLocation();//get the location of the piece.
            //each iteration took one step in the checked direction:
            for (; getCell().getBoard().isTheLocationOnBoard(checkedLocation); checkedLocation = checkedLocation.add(direction)) {
                IChessPiece piece = getCell().getBoard().getCell(checkedLocation).getPiece();

                //empty cell:
                if (piece == null) {
                    //not passable:
                    if (getCell().getBoard().getCell(checkedLocation).isRuleExist(new ImpassableRule(getColor()))) {
                        break;//you can not advance anymore in this direction
                    }
                }

                //occupied cell -> capture it:
                else {
                    //opponent:
                    if (piece.getColor() != getColor()) {
                        //capturable:
                        if (piece.isCapturable()) {
                            //capturing is allowed on the cell:
                            if (!piece.getCell().isRuleExist(new CapturingNotAllowedRule(getColor()))) {
                                //the piece is allowed to capture:
                                if (allowedToCapture()) {
                                    threatened.add(checkedLocation);//add threatened location
                                }
                            }
                        }
                    }
                    break;//stop if you reached an occupied cell
                }
            }
        }
        return threatened;
    }

    @Override
    public boolean allowedToCapture() {
        //todo
        return true;
    }

    @Override
    public boolean allowedToMove() {
        //todo
        return true;
    }
}
