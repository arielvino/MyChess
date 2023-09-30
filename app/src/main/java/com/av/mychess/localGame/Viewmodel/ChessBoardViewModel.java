/*
package com.av.mychess.Viewmodel;


import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IChessBoard;
import com.av.mychess.Interfaces.ModelInterfaces.IChessCell;
import com.av.mychess.Interfaces.ModelInterfaces.IChessGame;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.Interfaces.ModelInterfaces.ITurnInfo;
import com.av.mychess.Interfaces.ViewModelInterfaces.ICellViewModel;
import com.av.mychess.Interfaces.ViewModelInterfaces.IChessBoardViewModel;
import com.av.mychess.Interfaces.ViewModelInterfaces.IImageRepresentation;
import com.av.mychess.Interfaces.ViewModelInterfaces.ITarget;
import com.av.mychess.Test.TestGame;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

import java.util.ArrayList;

public class ChessBoardViewModel extends ViewModel implements IChessBoardViewModel {
    private Vector2D dimensions = new Vector2D(IChessBoard.DEFAULT_SIZE, IChessBoard.DEFAULT_SIZE);
    private IChessBoard boardModel;
    private ICellViewModel[][] cells;
    private ICellViewModel selected = null;
    private IChessGame game;
    private IChessBoardViewModel listeningView;

    public ChessBoardViewModel() {

        loadGame(new TestGame());
        //todo
    }


    @Nullable
    public ICellViewModel getCell(@Nullable Vector2D location) {
        if (location != null) {
            if (location.containedInRectangular(getDimensions())) {
                return cells[location.getX()][location.getY()];
            }
        }
        return null;
    }

    @Override
    public IChessGame getGame() {
        return game;
    }

    @Override
    public void loadGame(IChessGame game) {
        this.game = game;
        this.boardModel = game.getBoard();
        initializeTable(new Vector2D(boardModel.getDimensions().getX(), boardModel.getDimensions().getY()));
    }

    @Override
    public void setListeningView(@NotNull IChessBoardView listeningView) {
        this.listeningView = listeningView;
    }

    private void initializeTable(Vector2D dimensions) {
        this.dimensions = dimensions;
        cells = new ICellViewModel[dimensions.getX()][dimensions.getY()];
        for (int a = 0; a < dimensions.getX(); a++) {
            for (int b = 0; b < dimensions.getY(); b++) {
                ICellViewModel cell = new ChessCellViewModel(this, new Vector2D(a, b));
                cells[a][b] = cell;
            }
        }
    }

    @Override
    public void onCellClicked(Vector2D location) {
        ICellViewModel cell = getCell(location);

        //Not a target:
        if (cell.getTargetValue() == null) {
            IChessCell cellModel = boardModel.getCell(location);
            IChessPiece piece = cellModel.getPiece();

            //piece not null:
            if (piece != null) {
                //current turn:
                if (piece.getColor() == game.getCurrentTurn()) {
                    //select:
                    if (selected != cell) {
                        selectCellAt(cell.getLocation());
                        //todo
                    }
                    //unselect:
                    else {
                        selectCellAt(null);
                        //todo
                    }
                }
            }
        }
    }

    private void selectCellAt(@Nullable Vector2D location) {
        clearAllTargets();
        selected = getCell(location);
        listeningView.onSelectedCellChanged(location);
        //todo apply targets
    }

    private void clearAllTargets() {
        for (int x = 0; x < dimensions.getX(); x++) {
            for (int y = 0; y < dimensions.getY(); y++) {
                cells[x][y].setTargetValue(null);
            }
        }
    }


    @Override
    public Vector2D getSelectedCell(Vector2D location) {
        return selected.getLocation();
    }

    @Override
    public Vector2D getDimensions() {
        return dimensions;
    }

    /**
     * Test todo

    @TestOnly
    public ArrayList<ITurnInfo> testTargets(Vector2D location) {
        return boardModel.getCell(location).getPiece().getUncheckedPossibleTurns();
    }

    @Override
    public void onImageRepresentationChanged(@NotNull Vector2D location, @Nullable IImageRepresentation imageRepresentation) {

    }

    @Override
    public void onTargetValueChanged(@NotNull Vector2D location, @Nullable ITarget target) {

    }
}*/