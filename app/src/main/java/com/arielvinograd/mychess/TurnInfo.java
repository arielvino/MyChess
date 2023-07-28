package com.arielvinograd.mychess;

import java.util.ArrayList;

/**
 * This class is a block of data that represent a turn in the Game.
 * A block contain a title of the type TurnType (that indicate the
 * turn type, obviously), and a list of BasicStep that describe exactly
 * where every single piece moved, and the order of the moves - including
 * removed pieces and newly generated pieces.
 */
public class TurnInfo {
    private final TurnType title;

    /**
     * The title indicate the type of the turn.
     */
    public TurnType getTitle() {
        return title;
    }

    private final ArrayList<BasicStep> steps;

    /**
     * Returns the number of basic steps.
     */
    public int getStepsCount() {
        return steps.size();
    }

    public BasicStep[] getSteps() {

        return (BasicStep[]) steps.toArray();
    }

    /**
     * Return the step at the specified index.
     */
    public BasicStep getStep(int index) {
        return steps.get(index);
    }

    public TurnInfo(TurnType title, ArrayList<BasicStep> steps) {
        this.title = title;
        this.steps = steps;
    }
}
