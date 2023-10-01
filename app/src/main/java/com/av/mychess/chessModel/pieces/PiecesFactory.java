package com.av.mychess.chessModel.pieces;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PiecesFactory {
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

    public static String getImageName(@NotNull Class aClass, @NotNull PlayerColor color) {
        assert IChessPiece.class.isAssignableFrom(aClass) : "The specified type is not a chess piece.";

        String colorChar = color == PlayerColor.Black ? "b" : "w";
        return colorChar + "_" + aClass.getSimpleName().toLowerCase();
    }
}
