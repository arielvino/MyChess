package com.av.mychess.editor;

import android.content.Context;

import androidx.annotation.NonNull;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.ui.abstracts.AbstractChessBoardFragment;
import com.av.mychess.ui.abstracts.AbstractChessCellView;

public class EditorChessCellView extends AbstractChessCellView {
    public EditorChessCellView(@NonNull Context context, @NonNull AbstractChessBoardFragment board, @NonNull Vector2D location) {
        super(context, board, location);
    }
}
