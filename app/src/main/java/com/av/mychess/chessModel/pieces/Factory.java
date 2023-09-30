package com.av.mychess.chessModel.pieces;

import java.util.ArrayList;

public class Factory {
    private static final ArrayList<Class> pieceTypes = new ArrayList() {
        {
            add(Bishop.class);
            add(NightRider.class);
            add(Queen.class);
            add(Rook.class);

            //todo:add the rest of the pieces.
        }
    };

    public static ArrayList<Class> getPieceTypes() {
        return pieceTypes;
    }
}
