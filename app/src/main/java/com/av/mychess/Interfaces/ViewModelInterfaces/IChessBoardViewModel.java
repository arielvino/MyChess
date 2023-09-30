package com.av.mychess.Interfaces.ViewModelInterfaces;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IChessGame;

import org.jetbrains.annotations.NotNull;

public interface IChessBoardViewModel extends IChessGame.IGameEventsListener {
    void onCellClicked(@NotNull Vector2D location);
}
