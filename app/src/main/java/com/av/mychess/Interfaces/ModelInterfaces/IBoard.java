package com.av.mychess.Interfaces.ModelInterfaces;

import com.av.mychess.CommonStructs.Vector2D;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IBoard {
    @NotNull
    Vector2D getmDimensions();

    @Nullable
    ICell getCell(@Nullable Vector2D location);
}
