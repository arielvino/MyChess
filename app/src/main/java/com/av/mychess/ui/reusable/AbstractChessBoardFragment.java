package com.av.mychess.ui.reusable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IBoard;
import com.av.mychess.R;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractChessBoardFragment extends Fragment implements IBoard {

    private Vector2D dimensions = new Vector2D(0, 0);

    public AbstractChessBoardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_abstract_chess_board, container, false);
    }

    abstract public void drawTable(@NotNull Vector2D dimensions);
    abstract public void reloadFromViewModel();
}