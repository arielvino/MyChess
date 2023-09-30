package com.av.mychess.Interfaces.ViewInterfaces;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IBoard;
import com.av.mychess.Interfaces.ModelInterfaces.IChessGame;

import org.jetbrains.annotations.NotNull;

public interface IAbstractChessBoardFragment extends IBoard {
    void initializeTable(@NotNull Vector2D dimensions);


    //todo:
}
