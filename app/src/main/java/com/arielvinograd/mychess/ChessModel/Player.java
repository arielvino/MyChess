package com.arielvinograd.mychess.ChessModel;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Piece> pieces = new ArrayList<>();

    private final Game game;

    /**
     * The chess Game object that host this player.
     */
    public Game getGame(){
        return game;
    }

    private final PlayerColor color;

    /**
     * This methode determine whether the player is the black or the white in the game.
     */
    public PlayerColor getColor(){
        return color;
    }

    //Constructor:
    public Player(Game game, PlayerColor color)
    {
        if(game == null)
        {
            throw new NullPointerException("The Game object you tried to set is null.");
        }
        this.game = game;
        if(color==null){
            throw new NullPointerException("The PlayerColor value was null.");
        }
        this.color = color;
    }
}
