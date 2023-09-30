package com.av.mychess.chessModel;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IChessCell;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPlayer;

import java.util.ArrayList;
import java.util.List;

public class Player implements IChessPlayer {

    private final ArrayList<IChessPiece> pieces = new ArrayList<>();
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
        return pieces;
    }

    @Override
    public boolean isThreatening(IChessCell cell) {
        //each enemy piece:
        for (IChessPiece piece : game.getOpponent(color).getPieces()) {
            //each threatened location:
            for (Vector2D location : piece.getThreatenedLocations()) {
                if(location == cell.getLocation()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method determine whether the player is the black or the white in the game.
     */
    public PlayerColor getColor() {
        return color;
    }
}
