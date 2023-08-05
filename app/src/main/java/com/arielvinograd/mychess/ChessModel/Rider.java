package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IBasicAction;
import com.arielvinograd.mychess.Interfaces.IChessPiece;
import com.arielvinograd.mychess.Interfaces.ITarget;
import com.arielvinograd.mychess.Interfaces.Location;
import com.arielvinograd.mychess.Interfaces.PlayerColor;

import java.util.ArrayList;

public abstract class Rider extends Piece {

    public Rider(PlayerColor color) {
        super(color);
    }

    /**
     * This methode return a list of directions.
     * Direction is described by 1, 0, -1.
     * For example, the direction up is described as (0, 1), And the direction down-left is (-1, -1).
     *
     * @return list of Locations that are actually vectors that represent the general directions that the piece move along.
     */
    public abstract ArrayList<Location> directions();

    @Override
    public ArrayList<ITarget> getUncheckedPossibleTargets() {
        final ArrayList<ITarget> targets = new ArrayList<>();

        //if frozen or not on board - return an empty list:
        if (isFrozen() || !isOnBoard()) {
            return targets;
        }

        //each direction checked:
        for (Location direction : directions()) {
            Location checkedLocation = getCell().getLocation();//get the location of the piece.
            //each iteration took one step in the checked direction:
            for (; getCell().getBoard().isTheLocationOnBoard(checkedLocation); checkedLocation = checkedLocation.add(direction)) {
                IChessPiece piece = getCell().getBoard().getCell(checkedLocation).getPiece();
                //empty cell -> move to:
                if (piece == null) {
                    MoveAction movement = new MoveAction(getCell(), getCell().getBoard().getCell(checkedLocation));
                    ArrayList<IBasicAction> actions = new ArrayList<>();
                    actions.add(movement);
                    Target move = new Target(actions);
                    targets.add(move);
                }
                //occupied cell -> capture it:
                else {
                    //opponent:
                    if (piece.getColor() != getColor()) {
                        //capturable:
                        if (piece.isCapturable()) {
                            CaptureAction captureAction = new CaptureAction(piece, getCell(), piece.getCell());
                            ArrayList<IBasicAction> actions = new ArrayList<>();
                            actions.add(captureAction);
                            Target capture = new Target(actions);
                            targets.add(capture);
                            break;
                        }
                    }
                }
            }
        }
        return targets;
    }

    @Override
    public ArrayList<Location> getThreatenedLocations() {
        final ArrayList<Location> threatened = new ArrayList<>();

        //if the piece is frozen or not on board - return an empty list:
        if (isFrozen() || !isOnBoard()) {
            return threatened;
        }

        //each direction checked:
        for (Location direction : directions()) {
            Location checkedLocation = getCell().getLocation();//get the location of the piece.
            //each iteration took one step in the checked direction:
            for (; getCell().getBoard().isTheLocationOnBoard(checkedLocation); checkedLocation = checkedLocation.add(direction)) {
                IChessPiece piece = getCell().getBoard().getCell(checkedLocation).getPiece();

                //occupied cell -> capture it:
                if (piece != null) {
                    //opponent:
                    if (piece.getColor() != getColor()) {
                        //capturable:
                        if (piece.isCapturable()) {
                            threatened.add(checkedLocation);
                            break;
                        }
                    }
                }
            }
        }
        return threatened;
    }
}
