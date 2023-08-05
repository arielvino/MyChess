package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IBasicAction;
import com.arielvinograd.mychess.Interfaces.ITurnInfo;

import java.util.List;

/**
 * This class is a block of data that represent a turn in the Game.
 * A block contain a list of BasicAction that describe actions that have been done like Move, Capture, Promotion etc.
 */
public class TurnInfo implements ITurnInfo {

    @Override
    public List<IBasicAction> getActions() {
        //todo
        return null;
    }
}
