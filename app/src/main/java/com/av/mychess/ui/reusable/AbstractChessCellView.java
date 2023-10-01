package com.av.mychess.ui.reusable;

import android.content.Context;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IBoard;
import com.av.mychess.Interfaces.ModelInterfaces.ICell;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.R;
import com.av.mychess.chessModel.pieces.PiecesFactory;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractChessCellView extends androidx.appcompat.widget.AppCompatImageButton implements ICell {
    final AbstractChessBoardFragment chessBoard;
    private final Vector2D location;

    private IChessPiece piece;

    public AbstractChessCellView(@NotNull Context context, @NotNull AbstractChessBoardFragment board, @NotNull Vector2D location) {
        super(context);
        this.location = location;
        this.chessBoard = board;
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.height = (int) getResources().getDimension(R.dimen.chess_cell_size);
        params.width = (int) getResources().getDimension(R.dimen.chess_cell_size);
        setLayoutParams(params);
        setScaleType(ScaleType.FIT_XY);
        setPadding(5, 5, 5, 5);
        resetDefaultColor();
    }

    @NonNull
    @Override
    public IBoard getBoard() {
        return chessBoard;
    }

    @NonNull
    @Override
    public Vector2D getLocation() {
        return location;
    }

    public boolean isDark() {
        return (location.getX() + location.getY()) % 2 == 0;
    }

    @Nullable
    public IChessPiece getPiece() {
        return piece;
    }

    public void setPiece(@Nullable IChessPiece piece) {
        this.piece = piece;
        if (piece != null) {
            String resName = PiecesFactory.getImageName(piece.getClass(), piece.getColor());

            int resId = getResources().getIdentifier(resName, "drawable", getContext().getPackageName());
            setImageResource(resId);
        } else {
            setImageResource(0);
        }
        //todo
    }

    public void resetDefaultColor() {
        int color = isDark() ? R.color.dark_cell_color : R.color.light_cell_color;
        setBackgroundColor(getResources().getColor(color, getContext().getTheme()));
    }
}