package com.av.mychess.Interfaces;

import androidx.lifecycle.ViewModel;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.editor.EditorChessBoardFragment;
import com.av.mychess.editor.EditorChessCellViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class EditorChessBoardViewModel extends ViewModel {
    private Vector2D dimensions;
    private EditorChessBoardFragment fragment;
    private ArrayList<ArrayList<EditorChessCellViewModel>> cells;

    @Nullable
    public EditorChessCellViewModel getCell(@NotNull Vector2D location){
        return cells.get(location.getX()).get(location.getY());
    }

    @Nullable
    public Vector2D getDimensions() {
        return dimensions;
    }

    /**
     * This method is used for building entirely new table of cells in the viewModel, and as a sequences, in the view itself.
     * If you want to add or remove a specific row or column, or if you are looking for forcing the table into another size (which may include lose of cut off cells, and creation of whole empty ones) do not use this method.
     *
     * @param dimensions The size you want your board to be in.
     */
    public void initializeTable(@NotNull Vector2D dimensions) {
        this.dimensions = dimensions;
        cells = new ArrayList<>();
        for (int x = 0; x < dimensions.getX(); x++) {
            cells.add(new ArrayList<>());
            for (int y = 0; y < dimensions.getY(); y++) {
                cells.get(x).add(new EditorChessCellViewModel());
            }
        }

        //call the view's method:
        fragment.drawTable(dimensions);
    }

    public void connectToView(@NotNull EditorChessBoardFragment fragment) {
        this.fragment = fragment;
    }
}