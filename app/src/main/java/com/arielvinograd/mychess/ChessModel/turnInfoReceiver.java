package com.arielvinograd.mychess.ChessModel;

/**
 * This interface is a listener for the sendTurnInfo(TurnInfo turnInfo) methode that may be invoked from the Game class.
 */
public interface turnInfoReceiver {
    public void onTurnInfoReceived(TurnInfo turn);
}
