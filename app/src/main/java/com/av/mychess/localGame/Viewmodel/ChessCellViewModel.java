/*package com.av.mychess.Viewmodel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ViewModelInterfaces.ICellViewModel;
import com.av.mychess.Interfaces.ViewModelInterfaces.IChessBoardViewModel;
import com.av.mychess.Interfaces.ViewModelInterfaces.IImageRepresentation;
import com.av.mychess.Interfaces.ViewModelInterfaces.ITarget;

public class ChessCellViewModel implements ICellViewModel {
    private final IChessBoardViewModel board;
    private final Vector2D location;
    private ITarget targetValue;

    @Override
    @NonNull
    public IChessBoardViewModel getBoard() {
        return board;
    }

    @Override
    @NonNull
    public Vector2D getLocation() {
        return location;
    }

    @Override
    @Nullable
    public ITarget getTargetValue() {
        return targetValue;
    }

    @Override
    public void setTargetValue(@Nullable ITarget target) {
        this.targetValue = target;
        board.onTargetValueChanged(location, this.targetValue);
    }

    public ChessCellViewModel(@NonNull IBoardViewModel board, @NonNull Vector2D location){
        this.board = board;
        this.location = location;
    }
}
*/