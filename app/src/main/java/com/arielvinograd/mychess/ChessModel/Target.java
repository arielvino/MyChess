package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IBasicAction;
import com.arielvinograd.mychess.Interfaces.ITarget;

import java.util.ArrayList;

/**
 * This type hold info about a destination cell that a piece might move to, and what happen if it does.
 */
public class Target implements ITarget {
    private final ArrayList<IBasicAction> actions;

    public Target(ArrayList<IBasicAction> actions) {
        this.actions = (ArrayList<IBasicAction>) actions.clone();
    }

    public ArrayList<IBasicAction> getActions() {
        return (ArrayList<IBasicAction>) actions.clone();
    }
}
