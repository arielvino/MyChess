package com.av.mychess.ui.reusable;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.fragment.app.Fragment;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.R;
import com.av.mychess.chessModel.pieces.PiecesFactory;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PiecesBoxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PiecesBoxFragment extends Fragment {
    GridLayout piecesHolder;
    IResultPieceTypeReceiver resultPieceTypeReceiver;
    private PlayerColor mColor = PlayerColor.White;
    @NotNull
    private ArrayList<Class> typeList = new ArrayList<>();

    public PiecesBoxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EditorPiecesBoxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PiecesBoxFragment newInstance() {
        PiecesBoxFragment fragment = new PiecesBoxFragment();
        return fragment;
    }

    public PlayerColor getColor() {
        return mColor;
    }

    public void setColor(@NotNull PlayerColor color) {
        this.mColor = color;
        for (int i = 0; i < piecesHolder.getChildCount(); i++) {
            PieceTypeHolderButton button = (PieceTypeHolderButton) piecesHolder.getChildAt(i);
            button.setColor(color);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_editor_pieces_box, container, false);

        piecesHolder = view.findViewById(R.id.pieces_holder);

        typeList.addAll(PiecesFactory.getPieceTypes());

        //test
        typeList.addAll(PiecesFactory.getPieceTypes());
        typeList.addAll(PiecesFactory.getPieceTypes());
        typeList.addAll(PiecesFactory.getPieceTypes());
        typeList.addAll(PiecesFactory.getPieceTypes());
        //test-end

        piecesHolder.setRowCount(1);
        piecesHolder.setColumnCount(typeList.size());

        int x = 0, y = 0;
        for (Class aClass : typeList) {
            PieceTypeHolderButton piece = new PieceTypeHolderButton(getContext(), aClass, mColor);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) getResources().getDimension(R.dimen.chess_cell_size);
            params.height = (int) getResources().getDimension(R.dimen.chess_cell_size);

            //determine row:
            int emptyWidth = 0;

            //get screen width:
            DisplayManager displayManager = (DisplayManager) getContext().getSystemService(Context.DISPLAY_SERVICE);
            if (displayManager != null) {
                Display display = displayManager.getDisplay(Display.DEFAULT_DISPLAY);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getRealMetrics(displayMetrics);
                emptyWidth = displayMetrics.widthPixels;
            }

            emptyWidth = emptyWidth - piecesHolder.getPaddingStart() - piecesHolder.getPaddingEnd();
            emptyWidth = emptyWidth - x * params.width;

            //add row:
            if (emptyWidth < params.width) {
                y++;
                x = 0;
                piecesHolder.setRowCount(piecesHolder.getRowCount() + 1);
            }

            params.rowSpec = GridLayout.spec(y);//todo: dynamic row management.
            params.columnSpec = GridLayout.spec(x);//todo: manage it better.
            piece.setLayoutParams(params);

            piece.setOnClickListener(v -> {
                if (resultPieceTypeReceiver != null) {
                    resultPieceTypeReceiver.onPieceSelected(piece.getPieceType());
                }
            });

            piecesHolder.addView(piece);
            x++;
        }

        return view;
    }

    /**
     * This method attach a listener that react when a piece is selected.
     *
     * @param listener - the listener who listening (for example: a promotion dialog or an editor).
     */
    public void setPieceSelectedListener(@Nullable IResultPieceTypeReceiver listener) {
        resultPieceTypeReceiver = listener;
    }

    public interface IResultPieceTypeReceiver {
        void onPieceSelected(@NotNull Class<IChessPiece> piece);
    }
}