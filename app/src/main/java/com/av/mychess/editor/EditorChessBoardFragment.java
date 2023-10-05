package com.av.mychess.editor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.ICell;
import com.av.mychess.Interfaces.ModelInterfaces.IChessBoard;
import com.av.mychess.R;
import com.av.mychess.ui.reusable.AbstractChessBoardFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EditorChessBoardFragment extends AbstractChessBoardFragment {

    private final ArrayList<Vector2D> selectedLocations = new ArrayList<>();
    private GridLayout cellsHolder;
    private EditorChessCellView[][] cells;
    private EditorChessBoardViewModel mViewModel;
    private Vector2D mDimensions;

    public static EditorChessBoardFragment newInstance() {
        return new EditorChessBoardFragment();
    }

    public ArrayList<Vector2D> getSelectedLocations() {
        return selectedLocations;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        cellsHolder = view.findViewById(R.id.cells_grid);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EditorChessBoardViewModel.class);
        mViewModel.connectToView(this);

        //initialize the board with default size:
        mViewModel.initializeTable(new Vector2D(15, IChessBoard.DEFAULT_SIZE));
    }

    @NonNull
    @Override
    public Vector2D getmDimensions() {
        return mDimensions;
    }

    private void setDimensions(@NotNull Vector2D newDimensions) {
        mDimensions = newDimensions;
        //todo: update the viewModel.
        reloadFromViewModel();
    }

    @Nullable
    @Override
    public ICell getCell(@Nullable Vector2D location) {
        if (location == null) {
            return null;
        } else {
            return cells[location.getX()][location.getY()];
        }
    }

    @Override
    public void drawTable(@NonNull Vector2D dimensions) {
        mDimensions = dimensions;
        cells = new EditorChessCellView[dimensions.getX()][dimensions.getY()];
        cellsHolder.setColumnCount(mDimensions.getX());//todo: marginal labels.
        cellsHolder.setRowCount(mDimensions.getY());//todo: marginal labels.
        //add marginal labels on the top.
        for (int x = 0; x < mDimensions.getX(); x++) {
            //todo: add marginal label at the start.
            for (int y = 0; y < mDimensions.getY(); y++) {
                EditorChessCellView cell = new EditorChessCellView(getContext(), this, new Vector2D(x, y));
                GridLayout.LayoutParams params = (GridLayout.LayoutParams) cell.getLayoutParams();
                params.columnSpec = GridLayout.spec(x);//todo: add marginal label.
                params.rowSpec = GridLayout.spec(y);//todo: add marginal label.
                cell.setLayoutParams(params);

                //select / unselect on click:
                cell.setOnClickListener(view -> {
                    //check if already selected:
                    boolean selected = false;
                    for (Vector2D location : selectedLocations) {
                        if (cell.getLocation().identical(location)) {
                            selected = true;
                            break;
                        }
                    }
                    //clear old selected locations:
                    for (Vector2D location : selectedLocations) {
                        ((EditorChessCellView) getCell(location)).unSelect();
                    }
                    selectedLocations.clear();

                    //select:
                    if (!selected) {
                        selectedLocations.add(cell.getLocation());
                        cell.select();
                    }
                });


                cells[x][y] = cell;
                cellsHolder.addView(cell);
            }
            //todo: add marginal label on the end.
        }
        //todo: add marginal labels on the bottom.

        //todo
    }

    /**
     * This method sync the view with its viewModel state.
     * The table will be redrawn (if its size isn't match the viewModel), and all of the pieces will be reloaded.
     */
    @Override
    public void reloadFromViewModel() {
        drawTable(mViewModel.getDimensions());
        for (int x = 0; x < mViewModel.getDimensions().getX(); x++) {
            for (int y = 0; y < mViewModel.getDimensions().getY(); y++) {
                cells[x][y].setPiece(mViewModel.getCell(new Vector2D(x, y)).getPiece());
            }
        }
    }

    public EditorChessBoardViewModel getViewModel(){
        return mViewModel;
    }
}