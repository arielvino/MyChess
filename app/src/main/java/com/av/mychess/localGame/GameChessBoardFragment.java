package com.av.mychess.localGame;

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
import com.av.mychess.Interfaces.ModelInterfaces.IChessGame;
import com.av.mychess.R;
import com.av.mychess.ui.abstracts.AbstractChessBoardFragment;

public class GameChessBoardFragment extends AbstractChessBoardFragment {

    private GridLayout cellsHolder;
    private GameChessCellView[][] cells;
    private GameChessBoardViewModel mViewModel;
    private Vector2D mDimensions;

    public static GameChessBoardFragment newInstance() {
        return new GameChessBoardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        cellsHolder = rootView.findViewById(R.id.cells_grid);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GameChessBoardViewModel.class);
        // TODO: Use the ViewModel
    }

    @NonNull
    @Override
    public Vector2D getmDimensions() {
        return mDimensions;
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
        cells = new GameChessCellView[dimensions.getX()][dimensions.getY()];
        cellsHolder.setColumnCount(mDimensions.getY());//todo: marginal labels.
        cellsHolder.setRowCount(mDimensions.getY());//todo: marginal labels.
        //add marginal labels on the top.
        for (int x = 0; x < mDimensions.getX(); x++) {
            //todo: add marginal label at the start.
            for (int y = 0; y < mDimensions.getY(); y++) {
                GameChessCellView cell = new GameChessCellView(getContext(), this, new Vector2D(x, y));
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.columnSpec = GridLayout.spec(x);//todo: add marginal label.
                params.rowSpec = GridLayout.spec(y);//todo: add marginal label.
                cell.setLayoutParams(params);

                cellsHolder.addView(cell);
            }
            //todo: add marginal label on the end.
        }
        //todo: add marginal labels on the bottom.

        //todo
    }

    @Override
    public void reloadFromViewModel() {
        //todo
    }

    private void loadGame(@Nullable IChessGame game){
        if(game!=null){
            cellsHolder.removeAllViews();

            //draw the cells:
            drawTable(game.getBoard().getDimensions());

            
            //todo: implement
        }
        else {
            //todo: implements empty-preview.
        }
    }

}
