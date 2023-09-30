package com.av.mychess.Interfaces.ViewInterfaces;

import com.av.mychess.Interfaces.ModelInterfaces.ICell;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;

import org.jetbrains.annotations.Nullable;

public interface IChessCellViewAbstract extends ICell {
    @Nullable
    IChessPiece getPiece();

    void setPiece(@Nullable IChessPiece piece);
}
