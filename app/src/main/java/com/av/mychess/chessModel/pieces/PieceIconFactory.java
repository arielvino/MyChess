package com.av.mychess.chessModel.pieces;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;

import org.jetbrains.annotations.NotNull;

public class PieceIconFactory {
    public String getFileName(@NotNull IChessPiece piece) {
        String color = piece.getColor() == PlayerColor.White ? "w" : "b";
        return color + "_" + piece.getName().toLowerCase() + ".png";
    }
}
