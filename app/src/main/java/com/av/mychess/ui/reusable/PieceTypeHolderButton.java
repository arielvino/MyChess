package com.av.mychess.ui.reusable;

import android.content.Context;

import androidx.annotation.NonNull;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.chessModel.pieces.PiecesFactory;

import org.jetbrains.annotations.NotNull;

/**
 * This View is used as a button for inserting a Piece of specific type onto the board.
 */
public class PieceTypeHolderButton extends androidx.appcompat.widget.AppCompatImageButton {

    private final Class pieceType;
    private PlayerColor color;

    public PieceTypeHolderButton(@NonNull Context context, @NotNull Class pieceType, @NotNull PlayerColor color) {
        super(context);
        setScaleType(ScaleType.FIT_XY);
        setPadding(3,3,3,3);

        assert IChessPiece.class.isAssignableFrom(pieceType) : "The specified type is not a chess piece.";
        this.pieceType = pieceType;
        setColor(color);
    }

    public Class getPieceType() {
        return pieceType;
    }

    private void setImageResource(Class aClass) {
        assert IChessPiece.class.isAssignableFrom(pieceType) : "The specified type is not a chess piece.";
        int id = getContext().getResources().getIdentifier(PiecesFactory.getImageName(pieceType, color), "drawable", getContext().getPackageName());
        setImageResource(id);
    }

    public void setColor(@NotNull PlayerColor color) {
        this.color = color;
        setImageResource(pieceType);
    }
}
