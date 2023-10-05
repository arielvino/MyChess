package com.av.mychess.editor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IBoard;
import com.av.mychess.Interfaces.ModelInterfaces.ICell;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;

import org.jetbrains.annotations.NotNull;

public class EditorChessCellViewModel implements ICell {
    private IChessPiece piece;
    private final Vector2D location;

    private final EditorChessBoardViewModel board;

    public EditorChessCellViewModel(@NotNull EditorChessBoardViewModel board ,@NotNull Vector2D location) {
        this.board = board;
        this.location = location;
    }

    @Nullable
    public IChessPiece getPiece() {
        return piece;
    }

    public void setPiece(@Nullable IChessPiece piece) {
        this.piece = piece;
    }

    @NonNull
    @Override
    public IBoard getBoard() {
        return (IBoard) board;
    }

    @NonNull
    @Override
    public Vector2D getLocation() {
        return location;
    }
}
