package com.av.mychess.Interfaces.ModelInterfaces;

import com.av.mychess.CommonStructs.Vector2D;

import org.jetbrains.annotations.NotNull;

public interface ICell {
    @NotNull
    IBoard getBoard();

    @NotNull
    Vector2D getLocation();
}
