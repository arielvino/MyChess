package com.av.mychess.Interfaces.ViewModelInterfaces;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ICellViewModel {
    @NotNull
    Vector2D getLocation();

    @NotNull
    IChessBoardViewModel getBoard();

    @Nullable
    ITarget getTargetValue();

    void setTargetValue(@Nullable ITarget targetValue);

    @Nullable
    IChessPiece getPiece();

    void setPiece(@Nullable IChessPiece piece);
}
