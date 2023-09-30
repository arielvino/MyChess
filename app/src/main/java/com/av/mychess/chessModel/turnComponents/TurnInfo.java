package com.av.mychess.chessModel.turnComponents;

import com.av.mychess.Interfaces.ModelInterfaces.IBasicAction;
import com.av.mychess.Interfaces.ModelInterfaces.ITurnInfo;

import java.util.ArrayList;

/**
 * This class is a block of data that represent a turn in the Game.
 * A block contain a list of BasicAction that describe actions that have been done like Move, Capture, Promotion etc.
 */
public class TurnInfo implements ITurnInfo {

    private final ArrayList<IBasicAction> actions;

    @Override
    public ArrayList<IBasicAction> getActions() {
        return (ArrayList<IBasicAction>) actions.clone();
    }

    public TurnInfo(ArrayList<IBasicAction> actions){
        this.actions = actions;
    }
}
