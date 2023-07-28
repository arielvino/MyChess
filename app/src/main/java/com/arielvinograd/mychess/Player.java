package com.arielvinograd.mychess;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Piece> pieces = new ArrayList<>();

    private final Game game;
    public Game getGame(){
        return game;
    }

    //Constructor:
    public Player(Game game)
    {
        if(game == null)
        {
            throw new NullPointerException("The Game object you tried to set is null.");
        }
        this.game = game;
    }

    /**
     * This methode determine whether the player is the black or the white in the game.
     */
    public PlayerColor getColor() throws Exception {
        if(game.getWhite() == this){
            return PlayerColor.White;
        }
        if(game.getBlack() == this){
            return PlayerColor.Black;
        }
        throw new Exception("Seems like the player isn't belong to the right game.");
    }
}
