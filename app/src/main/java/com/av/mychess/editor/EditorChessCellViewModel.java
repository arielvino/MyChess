package com.av.mychess.editor;

import androidx.annotation.Nullable;

import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;

public class EditorChessCellViewModel {
    private IChessPiece piece;

    @Nullable
    public IChessPiece getPiece() {
        return piece;
    }

    public void setPiece(@Nullable IChessPiece piece) {
        this.piece = piece;
    }
}
