package com.arielvinograd.mychess.ChessModel;

import com.arielvinograd.mychess.Interfaces.IChessCell;
import com.arielvinograd.mychess.Interfaces.IChessPiece;
import com.arielvinograd.mychess.Interfaces.IChessPlayer;
import com.arielvinograd.mychess.Interfaces.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public class Player implements IChessPlayer {

    private final ArrayList<Piece> pieces = new ArrayList<>();
    private final Game game;
    private final PlayerColor color;

    //Constructor:
    public Player(Game game, PlayerColor color) {
        if (game == null) {
            throw new NullPointerException("The Game object you tried to set is null.");
        }
        this.game = game;
        if (color == null) {
            throw new NullPointerException("The PlayerColor value was null.");
        }
        this.color = color;
        //todo
    }

    /**
     * The chess Game object that host this player.
     */
    public Game getGame() {
        return game;
    }

    @Override
    public List<IChessPiece> getPieces() {
        //todo
        return null;
    }

    @Override
    public boolean isThreatening(IChessCell cell) {
        //todo
        return false;
    }

    /**
     * This methode determine whether the player is the black or the white in the game.
     */
    public PlayerColor getColor() {
        return color;
    }
}
