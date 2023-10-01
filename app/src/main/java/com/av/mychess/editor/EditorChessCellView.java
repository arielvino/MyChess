package com.av.mychess.editor;

import android.content.Context;

import androidx.annotation.NonNull;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.R;
import com.av.mychess.ui.reusable.AbstractChessBoardFragment;
import com.av.mychess.ui.reusable.AbstractChessCellView;

public class EditorChessCellView extends AbstractChessCellView {
    public EditorChessCellView(@NonNull Context context, @NonNull AbstractChessBoardFragment board, @NonNull Vector2D location) {
        super(context, board, location);
    }

    public void select() {
        int colorId = isDark() ? R.color.dark_selected_cell_color : R.color.light_selected_cell_color;
        setBackgroundColor(getContext().getResources().getColor(colorId, getContext().getTheme()));
    }
    public void unSelect(){
        int colorId = isDark() ? R.color.dark_cell_color : R.color.light_cell_color;
        setBackgroundColor(getContext().getResources().getColor(colorId, getContext().getTheme()));
    }
}
