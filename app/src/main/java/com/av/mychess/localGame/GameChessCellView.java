package com.av.mychess.localGame;

import android.content.Context;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ViewModelInterfaces.ITarget;
import com.av.mychess.R;
import com.av.mychess.ui.reusable.AbstractChessCellView;

/**
 * TODO: document your custom view class.
 */
public class GameChessCellView extends AbstractChessCellView {

    public GameChessCellView(Context context, @NonNull GameChessBoardFragment board, @NonNull Vector2D location) {
        super(context, board, location);
    }


    public void setDefaultColor() {
        int colorInt = getContext().getColor(isDark() ? R.color.dark_cell_color : R.color.light_cell_color);//todo: replace with runtime settings loading.
        setBackgroundColor(colorInt);
    }

    public void showTarget(@Nullable ITarget target) {
        if (target == null) {
            setDefaultColor();
        } else {
            int colorInt = isDark() ? Color.argb(200, 00, 255, 00) : Color.argb(255, 00, 255, 00);//todo: replace with runtime settings loading.
            //todo: add more versatile targets colors.
            setBackgroundColor(colorInt);
        }
    }

    public void select() {
        int colorInt = getContext().getColor(isDark() ? R.color.dark_selected_cell_color : R.color.light_selected_cell_color);//todo: replace with runtime settings loading.
        setBackgroundColor(colorInt);
    }


}